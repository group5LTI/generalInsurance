package com.lti.dto;

public class TravelSearchDto {
	
	String planType;
	int noOfPeople;
	String location; 
	int duration;
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
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
