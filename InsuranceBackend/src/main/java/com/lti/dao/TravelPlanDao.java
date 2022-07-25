package com.lti.dao;

import com.lti.entity.TravelInsurancePlan;

public interface TravelPlanDao {
	
	TravelInsurancePlan addOrUpdate(TravelInsurancePlan tp);
	 TravelInsurancePlan searchTravelPlanById(int travelPlanId);
}
