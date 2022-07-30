package com.lti.service;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.dto.BuyVInsuranceDto;
import com.lti.dto.RenewVInsuranceDto;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

public interface VehicleService {
	
	
	VehicleInsurance buyInsurance(VehicleInsurance vehicleInsurance);
	
	RenewVehicleInsurance renewVehicleInsurance(RenewVInsuranceDto vehicleInsurance);
	
	String RegisterVehiclePlan(VehicleInsurancePlan vehicleInsurancePlan);
	
	Vehicle ResgisterVehicle(Vehicle vehicle);
	
	VehicleInsurancePlan searchPlanById(int planId);
	
	VehicleInsurancePlan searchPlanByDurationType(String vehicleType,String planType,int planDuration);

	Insurance addVehicleInsurance(Insurance vi);
}
