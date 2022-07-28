package com.lti.dao;

import java.util.List;

import com.lti.entity.VehicleInsurancePlan;

public interface VehiclePlanDao {

	VehicleInsurancePlan addOrUpdateVehiclePlan(VehicleInsurancePlan vip);

	VehicleInsurancePlan searchVehiclePlan(int vehiclePlanId);
	
	List<VehicleInsurancePlan> viewAllVehicleInsurancePlans();

}
