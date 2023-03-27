package com.knimbus.test.model;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainSchedule {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date currentDate;
	
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public ArrayList<LineModel> getLineModel() {
		return lineModel;
	}
	public void setLineModel(ArrayList<LineModel> lineModel) {
		this.lineModel = lineModel;
	}
	private ArrayList<LineModel> lineModel;
}