package com.lti.dao;

import java.util.List;

import com.lti.entity.VehicleInsurance;

public interface VehicleInsuranceDao {

	VehicleInsurance addOrUpdateVehicleInsurance(VehicleInsurance vehicleInsurance);
	
	VehicleInsurance searchVehicleInsuraceById(int vehicleInsuranceId);
	
}
//