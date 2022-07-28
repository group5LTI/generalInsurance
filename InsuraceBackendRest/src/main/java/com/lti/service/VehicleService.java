package com.lti.service;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.VehicleInsurance;

public interface VehicleService {
	
	
	String buyInsurance(VehicleInsurance vehicleInsurance);
	
	RenewVehicleInsurance renewVehicleInsurance(VehicleInsurance vehicleInsurance);
	
	

}
