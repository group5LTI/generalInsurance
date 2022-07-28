
package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

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
	//7002 tested //ADDED TO CHECK 'INSURANCE' TEST
	@Test
	public void addVehicleInsuranceTest() {
		VehicleInsurance vi = new VehicleInsurance();
		vi.setAmountPaidV(1000);
		vi.setIssueDate(LocalDate.of(2022, 7, 25));
		vi.setYears(1);
		Vehicle v = daov.searchVehicleById(1002);
		vi = v.getVehicleInsurance();
		if(vi==null) {
		VehicleInsurancePlan vp = daovp.searchVehiclePlan(8001);
		vi.setVehicle(v);
		vi.setVehicleInsurancePlan(vp);
		
		VehicleInsurance vehicleInsurance = dao.addOrUpdateVehicleInsurance(vi);
		assertNotNull(vehicleInsurance);
		}
		else {
			System.out.println("Vehicle has already been insured..Renew Insurance");
		}
		
	}
	//tested
	@Test
	public void TestSearchVehicleInsuranceById() {
		VehicleInsurance vi = dao.searchVehicleInsuraceById(7002);
		assertNotNull(vi);
	}
	//tested
	@Test
	public void TestViewAllVehicleInsurances() {
		List<VehicleInsurance> lists = dao.viewAllVehicleInsurance();
		assertNotEquals(0, lists.size());
	}

}
