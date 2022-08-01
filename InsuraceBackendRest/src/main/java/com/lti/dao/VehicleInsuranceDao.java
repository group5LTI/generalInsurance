package com.lti.dao;

import java.util.List;

import com.lti.entity.VehicleInsurance;

public interface VehicleInsuranceDao {

	VehicleInsurance addOrUpdateVehicleInsurance(VehicleInsurance vehicleInsurance);

	VehicleInsurance searchVehicleInsuraceById(int vehicleInsuranceId);

	List<VehicleInsurance> viewAllVehicleInsurance();

	List<VehicleInsurance> viewAllVehicleInsurancesByUserId(int userId);

	List<VehicleInsurance> viewAllVehicleInsurancesByUserName(String userName);
	
//	List<VehicleInsurance> viewAllVehicleInsuranceByName(String userName);
}
//