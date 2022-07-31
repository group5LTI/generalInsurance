package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InsuranceDao;
import com.lti.dao.TravelInsuranceDao;
import com.lti.dao.TravelPlanDao;
import com.lti.dto.TravelSearchDto;
import com.lti.entity.Insurance;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	TravelInsuranceDao travelDao;
	
	@Autowired
	TravelPlanDao travelPlanDao;
	
	@Autowired
	InsuranceDao insurancedao;
	
	@Override
	public TravelInsurance buyTravelInsurance(TravelInsurance travleInsurance) {
		TravelInsurance ti;
		try {
			ti=travelDao.addOrUpdateTravelInsurance(travleInsurance);
			return ti;
		} 
				catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public TravelInsurance searchTravelInsuranceById(int TravelInsuranceId) {
	
		return travelDao.searchTravelInsuranceById(TravelInsuranceId);
	}

	@Override
	public String RegisterTravelPlan(TravelInsurancePlan travelInsurancePlan) {
		TravelInsurancePlan travelPlan;
		try {
			travelPlan = travelPlanDao.addOrUpdate(travelInsurancePlan);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Travel Plan Added Successfully plan Id"+travelPlan.getTravelPlanId();
	}

	@Override
	public TravelInsurancePlan searchPlanById(int planId) {
		// TODO Auto-generated method stub
		return travelPlanDao.searchTravelPlanById(planId);
	}

	@Override
	public TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType(String planType,int noOfPeople,String location,int duration) {
		// TODO Auto-generated method stub
		return travelPlanDao.searchPlanByPeoplePlanLocationDurationType(planType,noOfPeople,location,duration);
	}

	@Override
	public Insurance addTravelInsurance(Insurance ti) {
		Insurance in;
		try {
			in = insurancedao.addInsurance(ti);
			return in;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
