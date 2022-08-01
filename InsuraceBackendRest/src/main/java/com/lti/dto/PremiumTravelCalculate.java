package com.lti.dto;

public class PremiumTravelCalculate {
	String location;
	String travelStartDate;
	String travelEndDate;
	int noOfPeople;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
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
	
}
