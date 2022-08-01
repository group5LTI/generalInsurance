package com.lti.dao;

import java.util.List;

import com.lti.dto.TravelSearchDto;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

public interface TravelPlanDao {

	TravelInsurancePlan addOrUpdate(TravelInsurancePlan tp);

	TravelInsurancePlan searchTravelPlanById(int travelPlanId);
	
	TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType(String planType,int noOfPeople,String location,int duration);
	
	List<TravelInsurancePlan> viewAllTravelPlans();
//<<<<<<< HEAD
	
	TravelInsurancePlan searchPlanByPeoplePlanLocationDuration(int noOfPeople, String location, int duration);
	
//=======
//
//	TravelInsurancePlan searchPlanByPeoplePlanLocationDuration(int noOfPeople, String location, int duration);
//>>>>>>> cdae998a8de68d50a6b33b9ed34e137979e7b7e9
}
