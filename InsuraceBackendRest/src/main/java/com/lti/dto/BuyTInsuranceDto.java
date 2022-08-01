package com.lti.dto;

public class BuyTInsuranceDto {

	int userId;
	String location;
	String travelStartDate;
	String travelEndDate;
	String planType;
	int noOfPeople;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	
	
}
