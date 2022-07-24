package com.lti.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.TravelInsuranceDao;
import com.lti.dao.TravelPlanDao;
import com.lti.entity.Customer;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

public class TravelInsuranceTest {
	
	TravelInsuranceDao dao;
	CustomerDao daoc;
	TravelPlanDao daotp;
	
	@Before
	public void initializeDao() {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(TravelInsuranceDao.class);
		daoc = context.getBean(CustomerDao.class);
		daotp = context.getBean(TravelPlanDao.class);
	}
	
	@Test
	public void addTravelInsurance() {
		TravelInsurance ti = new TravelInsurance();
		ti.setAmountPaid(1000);
		ti.setLocation("Sillicon Valley");
		ti.setTravelStartDate(LocalDate.of(2022, 8, 1));
		ti.setTravelEndDate(LocalDate.of(2022, 11, 1));
		Customer c = daoc.searchCustomer(100);
		TravelInsurancePlan tip = daotp.searchTravelPlanById(6000);
		
		ti.setCustomer(c);
		ti.setTravelInsurancePlan(tip);
		
		TravelInsurance travelInsurance = dao.addOrUpdateTravelInsurance(ti);
		assertNotNull(travelInsurance);
		
	}

}
