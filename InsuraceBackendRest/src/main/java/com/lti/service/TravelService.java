package com.lti.service;


import com.lti.dto.CalTravelDto;

import java.util.List;


import com.lti.dto.TravelSearchDto;
import com.lti.entity.Insurance;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

public interface TravelService {
	
	TravelInsurance buyTravelInsurance(TravelInsurance travleInsurance);

	TravelInsurance searchTravelInsuranceById(int TravelInsuranceId);

	String RegisterTravelPlan(TravelInsurancePlan travelInsurancePlan);

	TravelInsurancePlan searchPlanById(int planId);

	TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType(String planType,int noOfPeople,String location,int duration);

	TravelInsurancePlan searchPlanByPeoplePlanLocationDuration(int noOfPeople,String location,int duration);
	
	Insurance addTravelInsurance(Insurance ti);
//<<<<<<< HEAD
//	
////	TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType1(CalTravelDto calTravelDto);
//	
//	TravelInsurancePlan searchPlanByPeoplePlanLocationDuration(int noOfPeople,String location,int duration);
//	
//	
//
//=======

	List<TravelInsurance> viewAllTravelInsurancesByUserName(String uname);
//>>>>>>> cdae998a8de68d50a6b33b9ed34e137979e7b7e9
}
