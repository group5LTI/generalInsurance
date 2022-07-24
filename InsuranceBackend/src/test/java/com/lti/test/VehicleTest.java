package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.VehicleDao;
import com.lti.entity.Customer;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleType;

public class VehicleTest {
	VehicleDao daov;
	CustomerDao daoc;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		daov = context.getBean(VehicleDao.class);
		daoc = context.getBean(CustomerDao.class);
	}

	@Test
	public void addVehicleTest() {
		Vehicle v = new Vehicle();
		Customer customer = daoc.searchCustomer(100);
		v.setBrand("TATA");
		v.setChassisNumber("12345677890");
		v.setDrivinglicence("ADFB134567");
		v.setVehicleType(VehicleType.fourWheeler);
		v.setCustomer(customer);
		
		Vehicle vehicle = daov.addOrUpdateVehicle(v);
//		
		assertNotNull(vehicle);
		
	}

}
