package com.lti.dao;

import java.util.List;

import com.lti.entity.Insurance;

public interface InsuranceDao {

	Insurance addInsurance(Insurance insurance);
	
	Insurance searchInsurance(int insuranceId);
	
	List<Insurance> viewAllInsurances();
	
	Insurance searchInsuranceByVehicleInsuranceId(int vehicleInsuranceId);
	
	Insurance searchInsuranceByTravelInsuranceId(int travelInsuranceId);
	
}
