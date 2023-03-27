package com.knimbus.test.model;

import java.util.ArrayList;

public class Root{
    public ArrayList<Data> data;
    public ArrayList<Included> included;
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	public ArrayList<Included> getIncluded() {
		return included;
	}
	public void setIncluded(ArrayList<Included> included) {
		this.included = included;
	}
}

