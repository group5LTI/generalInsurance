package com.lti.dao;

import java.util.List;

import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

public interface TravelPlanDao {

	TravelInsurancePlan addOrUpdate(TravelInsurancePlan tp);

	TravelInsurancePlan searchTravelPlanById(int travelPlanId);
	
	List<TravelInsurancePlan> viewAllTravelPlans();
}
