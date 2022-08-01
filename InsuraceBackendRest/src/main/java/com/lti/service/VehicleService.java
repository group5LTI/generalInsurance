package com.lti.service;

import java.util.List;

import com.lti.dto.BuyVInsuranceDto;
import com.lti.dto.RenewVInsuranceDto;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

public interface VehicleService {
	
	
	VehicleInsurance buyInsurance(VehicleInsurance vehicleInsurance);
	
	VehicleInsurance searchVehicleInsuranceById(int vehicleInsuranceId);
	
	
//	boolean renewVehicleInsurance(RenewVInsuranceDto vehicleInsurance);
	
	String RegisterVehiclePlan(VehicleInsurancePlan vehicleInsurancePlan);
	
	Vehicle ResgisterVehicle(Vehicle vehicle);
	
	Vehicle searchVehicleByVehicleId(int vehicleId);
	
	VehicleInsurancePlan searchPlanById(int planId);
	
	VehicleInsurancePlan searchPlanByDurationType(String vehicleType,String planType,int planDuration);

	Insurance addVehicleInsurance(Insurance vi);
	

	VehicleInsurancePlan searchPlanByDurationInsuranceType(String vehicleType,String insuranceType,int planDuration);

	List<VehicleInsurance> viewAllVehicleInsurances();
	
	
	
}
