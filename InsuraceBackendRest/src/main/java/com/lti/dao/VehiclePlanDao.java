package com.lti.dao;

import java.util.List;

import com.lti.dto.VehicleSearchDto;
import com.lti.entity.VehicleInsurancePlan;

public interface VehiclePlanDao {

	VehicleInsurancePlan addOrUpdateVehiclePlan(VehicleInsurancePlan vip);

	VehicleInsurancePlan searchVehiclePlanById(int vehiclePlanId);
	
	List<VehicleInsurancePlan> viewAllVehicleInsurancePlans();
	
	VehicleInsurancePlan searchVehiclePlan(String vehicleType,String planType ,int years);
	
	VehicleInsurancePlan searchPlanByVehicleTypeYear(VehicleSearchDto dto1);

}
