package com.lti.dto;

import com.lti.entity.TravelInsurancePlan;

public class ReturnMessageTravelPremium {

	String message;
	TravelInsurancePlan plan;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TravelInsurancePlan getPlan() {
		return plan;
	}
	public void setPlan(TravelInsurancePlan plan) {
		this.plan = plan;
	}
	
	
}