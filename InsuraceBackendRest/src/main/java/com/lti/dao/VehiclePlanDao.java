package com.lti.dao;

import com.lti.entity.VehicleInsurancePlan;

public interface VehiclePlanDao {

	VehicleInsurancePlan addOrUpdateVehiclePlan(VehicleInsurancePlan vip);

	VehicleInsurancePlan searchVehiclePlan(int vehiclePlanId);

}
