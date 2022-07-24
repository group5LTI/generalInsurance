package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.VehicleDao;
import com.lti.dao.VehicleInsuranceDao;
import com.lti.dao.VehiclePlanDao;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

public class VehicleInsuranceTest {
	VehicleInsuranceDao dao;
	VehicleDao daov;
	VehiclePlanDao daovp;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(VehicleInsuranceDao.class);
		daov = context.getBean(VehicleDao.class);
		daovp = context.getBean(VehiclePlanDao.class);
		
	}

	@Test
	public void addVehicleInsuranceTest() {
		VehicleInsurance vi = new VehicleInsurance();
		vi.setAmountPaidV(1000);
		vi.setIssueDate(LocalDate.of(2022, 7, 25));
		vi.setYears(1);
		Vehicle v = daov.searchVehicleById(1000);
		VehicleInsurancePlan vp = daovp.searchVehiclePlan(8000);
		vi.setVehicle(v);
		vi.setVehicleInsurancePlan(vp);
		
		VehicleInsurance vehicleInsurance = dao.addOrUpdateVehicleInsurance(vi);
		assertNotNull(vehicleInsurance);
		
	}

}
