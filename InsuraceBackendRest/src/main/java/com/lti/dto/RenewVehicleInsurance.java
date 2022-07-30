package com.lti.dto;

import com.lti.entity.VehicleInsurance;

public class RenewVehicleInsurance {
	String message;
	VehicleInsurance vehicleInsurance;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}
	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}
	
}
