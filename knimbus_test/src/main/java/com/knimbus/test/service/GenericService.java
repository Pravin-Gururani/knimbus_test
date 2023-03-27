package com.knimbus.test.service;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.knimbus.test.model.Data;
import com.knimbus.test.model.Included;
import com.knimbus.test.model.LineModel;
import com.knimbus.test.model.Root;
import com.knimbus.test.model.TrainSchedule;

@Service
public class GenericService {

	Logger logger = LoggerFactory.getLogger(GenericService.class);
	
	private static final String url = "https://api-v3.mbta.com/predictions/?filter[direction_id]=0&filter[stop]=place-pktrm&sort=departure_time&include=route&page[limit]=10";

	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<String> getNextTenTrainDetails() {
		Root root = null;
		Instant now = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now, ZoneId.of("US/Michigan"));
		Date currentDate = Date.from(zdt.toInstant());;
		TrainSchedule trainSchedule = new TrainSchedule();
		ArrayList<LineModel> lineModels = new ArrayList<LineModel>();
		trainSchedule.setCurrentDate(currentDate);
		String scheduleDetails = "No train scheduled from this station";
		try {
			root = restTemplate.getForObject(url, Root.class);
		}catch (Exception e) {
			logger.error("Something went wrong {}", e.getMessage());
		}
		
		if(null != root && !CollectionUtils.isEmpty(root.getData())) {
			for(Data data : root.getData()) {
				if(null != data.getAttributes().getDeparture_time() && currentDate.compareTo(data.getAttributes().getDeparture_time()) != 1) {
					LineModel lineModel = new LineModel();
					lineModel.setDepartureTime(data.getAttributes().getDeparture_time());
					lineModel.setLineId(data.getRelationships().getRoute().getData().getId());
					this.filterAndGetDataFromIncluded(root, lineModel);
					lineModels.add(lineModel);
				}
			}
			trainSchedule.setLineModel(lineModels);
		}
		return new ResponseEntity<String>(this.setScheduledDetails(scheduleDetails, trainSchedule), HttpStatus.OK);
	}
	
	private String setScheduledDetails(String scheduleDetails, TrainSchedule trainSchedule) {
		if(!CollectionUtils.isEmpty(trainSchedule.getLineModel())) {
			scheduleDetails = trainSchedule.getCurrentDate().toString();
			Map<String, List<LineModel>> lineModelMap = trainSchedule.getLineModel()
					.stream()
					.collect(Collectors.groupingBy(LineModel :: getLine))
					.entrySet()
					.stream()
					.sorted(
							(map1, map2) -> map1.getValue().get(0).getDepartureTime().compareTo(map2.getValue().get(0).getDepartureTime())
							)
					.collect(
		                    Collectors.toMap(
		                            Map.Entry::getKey, 
		                            Map.Entry::getValue, 
		                            (es1, es2) -> es1, LinkedHashMap::new
		                            )
		                    );
			for (var entry : lineModelMap.entrySet()) {
				scheduleDetails = scheduleDetails.concat("\n-----" + entry.getKey() + "-----");
				for(LineModel lineModel : entry.getValue()) {
					if(lineModel.getDepartureTimeInMinutes() == 0) {
						scheduleDetails = scheduleDetails.concat("\n" + lineModel.getStationName() + ": Departuring now(0 minutes)");
					}else {
						scheduleDetails = scheduleDetails.concat("\n" + lineModel.getStationName() + ": Departing in " + lineModel.getDepartureTimeInMinutes() + " minutes");
					}
				}
			}
					
		}
		return scheduleDetails;
	}

	private void filterAndGetDataFromIncluded(Root root, LineModel lineModel) {
		if(!CollectionUtils.isEmpty(root.getIncluded())) {
			Included included = root.getIncluded().stream().filter(include -> include.getId().equals(lineModel.getLineId())).findFirst().orElse(null);
			if(null != included && null != included.getAttributes()) {
				lineModel.setLine(included.getAttributes().getLong_name());
				lineModel.setStationName(!CollectionUtils.isEmpty(included.getAttributes().getDirection_destinations()) ? included.getAttributes().getDirection_destinations().get(0) : "");
				lineModel.setDepartureTimeInMinutes(this.getDepartureTimeInMinutes(lineModel.getDepartureTime()));
			}
		}
	}
	
	private long getDepartureTimeInMinutes(Date departureTime) {
		long duration  = departureTime.getTime() - new Date().getTime();
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		return diffInMinutes;
	}

	

}
