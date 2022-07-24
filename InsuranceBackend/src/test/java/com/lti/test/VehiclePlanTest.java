package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.VehiclePlanDao;
import com.lti.entity.InsuranceType;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.entity.VehicleType;

public class VehiclePlanTest {

	VehiclePlanDao dao;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(VehiclePlanDao.class);
	}
	@Test
	public void addOrUpdateVehiclePlantest() {
		VehicleInsurancePlan vip = new VehicleInsurancePlan();
		vip.setInsuranceType(InsuranceType.ThirdParty);
		vip.setNoOfYears(1);
		vip.setPlannedAmountV(1000);
		vip.setVehicleType(VehicleType.twoWheeler);
		
		VehicleInsurancePlan vehiclePlan = dao.addOrUpdateVehiclePlan(vip);
		assertNotNull(vehiclePlan);
	}

}
