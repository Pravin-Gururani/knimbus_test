package com.knimbus.test.model;

import java.util.Date;

public class LineModel {
	
	private String line;
	private String lineId;
	private String stationName;
	private Long departureTimeInMinutes;
	private Date departureTime; 
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Long getDepartureTimeInMinutes() {
		return departureTimeInMinutes;
	}
	public void setDepartureTimeInMinutes(Long departureTimeInMinutes) {
		this.departureTimeInMinutes = departureTimeInMinutes;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
}

