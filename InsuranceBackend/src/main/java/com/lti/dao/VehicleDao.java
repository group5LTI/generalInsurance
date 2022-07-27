package com.lti.dao;

import java.util.List;

import com.lti.entity.Vehicle;

public interface VehicleDao {

	Vehicle addOrUpdateVehicle(Vehicle vehicle);

	Vehicle searchVehicleById(int vehicleId);

	List<Vehicle> viewAllVehicles();

}
