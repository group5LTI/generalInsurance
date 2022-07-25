package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.TravelPlanDao;
import com.lti.entity.TravelInsurancePlan;

public class TravelPlanTest {
	TravelPlanDao dao;
	
	@Before
	public void initializeDao(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(TravelPlanDao.class);
	}

	@Test
	public void addTravelPlanTest() {
		TravelInsurancePlan tip = new TravelInsurancePlan();
		tip.setNoOfPeople(10);
		tip.setPlannedAmount(1000);
		tip.setTravelLocation("Sillicon Valley");
		tip.setTravleDuration(3);
		
		TravelInsurancePlan travelPlan = dao.addOrUpdate(tip);
		assertNotNull(travelPlan);
		
	}

}
