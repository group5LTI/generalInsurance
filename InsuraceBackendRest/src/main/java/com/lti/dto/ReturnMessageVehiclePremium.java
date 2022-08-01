package com.lti.dto;

import com.lti.entity.VehicleInsurancePlan;

public class ReturnMessageVehiclePremium {

	String message;
	VehicleInsurancePlan vip;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public VehicleInsurancePlan getVip() {
		return vip;
	}
	public void setVip(VehicleInsurancePlan vip) {
		this.vip = vip;
	}
	
	
}