package com.lti.dao;

import java.util.List;

import com.lti.dto.TravelSearchDto;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

public interface TravelPlanDao {

	TravelInsurancePlan addOrUpdate(TravelInsurancePlan tp);

	TravelInsurancePlan searchTravelPlanById(int travelPlanId);
	
	TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType(TravelSearchDto dtol);
	
	List<TravelInsurancePlan> viewAllTravelPlans();
}
