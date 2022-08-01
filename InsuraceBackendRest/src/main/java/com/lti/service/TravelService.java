package com.lti.service;

import com.lti.dto.CalTravelDto;
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

	Insurance addTravelInsurance(Insurance ti);
	
//	TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType1(CalTravelDto calTravelDto);
	
	TravelInsurancePlan searchPlanByPeoplePlanLocationDuration(int noOfPeople,String location,int duration);
	
	

}
