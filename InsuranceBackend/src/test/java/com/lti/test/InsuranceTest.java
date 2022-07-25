package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.InsuranceDao;
import com.lti.dao.VehicleInsuranceDao;
import com.lti.entity.Insurance;
import com.lti.entity.VehicleInsurance;

public class InsuranceTest {

	InsuranceDao dao;
	VehicleInsuranceDao daovi;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(InsuranceDao.class);
		daovi = context.getBean(VehicleInsuranceDao.class);
	}
	@Test
	public void insuranceAddTest() {
		Insurance i = new Insurance();
		VehicleInsurance vi = daovi.searchVehicleInsuraceById(7000);
		i.setVehicleInsurance(vi);
		
		Insurance insurance = dao.addInsurance(i);
		assertNotNull(insurance);
	}

}
