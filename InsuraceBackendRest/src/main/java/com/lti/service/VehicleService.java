package com.lti.service;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

public interface VehicleService {
	
	
	String buyInsurance(VehicleInsurance vehicleInsurance);
	
	RenewVehicleInsurance renewVehicleInsurance(VehicleInsurance vehicleInsurance);
	
	String RegisterVehiclePlan(VehicleInsurancePlan vehicleInsurancePlan);
	
	String ResgisterVehicle(Vehicle vehicle);
}
