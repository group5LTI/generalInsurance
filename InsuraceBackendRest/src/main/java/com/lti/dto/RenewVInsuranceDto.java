package com.lti.dto;

public class RenewVInsuranceDto {

	int vehicleInsuranceId;
	int userId;
	int planDuration;
	String planType;
	
	
	
	public int getVehicleInsuranceId() {
		return vehicleInsuranceId;
	}
	public void setVehicleInsuranceId(int vehicleInsuranceId) {
		this.vehicleInsuranceId = vehicleInsuranceId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPlanDuration() {
		return planDuration;
	}
	public void setPlanDuration(int planDuration) {
		this.planDuration = planDuration;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	
	
}
