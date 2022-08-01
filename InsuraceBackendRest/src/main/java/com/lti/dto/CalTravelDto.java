package com.lti.dto;

public class CalTravelDto {
	String travelStartDate;
	String travelEndDate;
	int noOfPeople;
	String location; 
	int duration;
	public String getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(String travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public String getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(String travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public int getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
