package com.lti.dao;

import com.lti.entity.Vehicle;

public interface VehicleDao {

	Vehicle addOrUpdateVehicle(Vehicle vehicle);
	
	Vehicle searchVehicleById(int vehicleId);
	
}
