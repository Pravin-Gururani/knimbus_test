package com.knimbus.test.model;

import java.util.ArrayList;
import java.util.Date;

public class Attributes{
    public Date getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}
	public int getDirection_id() {
		return direction_id;
	}
	public void setDirection_id(int direction_id) {
		this.direction_id = direction_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStop_sequence() {
		return stop_sequence;
	}
	public void setStop_sequence(int stop_sequence) {
		this.stop_sequence = stop_sequence;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getDirection_destinations() {
		return direction_destinations;
	}
	public void setDirection_destinations(ArrayList<String> direction_destinations) {
		this.direction_destinations = direction_destinations;
	}
	public ArrayList<String> getDirection_names() {
		return direction_names;
	}
	public void setDirection_names(ArrayList<String> direction_names) {
		this.direction_names = direction_names;
	}
	public String getFare_class() {
		return fare_class;
	}
	public void setFare_class(String fare_class) {
		this.fare_class = fare_class;
	}
	public String getLong_name() {
		return long_name;
	}
	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public String getText_color() {
		return text_color;
	}
	public void setText_color(String text_color) {
		this.text_color = text_color;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date departure_time;
    public int direction_id;
    public String status;
    public int stop_sequence;
    public String color;
    public String description;
    public ArrayList<String> direction_destinations;
    public ArrayList<String> direction_names;
    public String fare_class;
    public String long_name;
    public String short_name;
    public int sort_order;
    public String text_color;
    public int type;
}

