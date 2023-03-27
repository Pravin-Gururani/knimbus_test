package com.knimbus.test.model;
public class Relationships{
    public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Stop getStop() {
		return stop;
	}
	public void setStop(Stop stop) {
		this.stop = stop;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Route route;
    public Stop stop;
    public Trip trip;
    public Vehicle vehicle;
    public Line line;
}

