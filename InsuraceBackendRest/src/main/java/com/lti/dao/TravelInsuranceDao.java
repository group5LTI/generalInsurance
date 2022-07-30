package com.lti.dao;

import java.util.List;

import com.lti.entity.TravelInsurance;

public interface TravelInsuranceDao {
	
	TravelInsurance addOrUpdateTravelInsurance(TravelInsurance travelInsurance);
	
	TravelInsurance searchTravelInsuranceById(int travelInsuranceId);
	
	List<TravelInsurance> viewAllTravelInsurances();
}
