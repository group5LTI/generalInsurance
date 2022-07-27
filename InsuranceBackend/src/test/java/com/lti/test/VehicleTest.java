package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

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
	//tested for 104 already //ADDED TO CHECK 'INSURANCE' TEST
	@Test
	public void addVehicleTest() {
		Vehicle v = new Vehicle();
		Customer customer = daoc.searchCustomer(104);
		v.setBrand("BMW");
		v.setChassisNumber("42345677891");
		v.setDrivinglicence("ADFB134567");
		v.setVehicleType(VehicleType.fourWheeler);
		v.setCustomer(customer);
		
		Vehicle vehicle = daov.addOrUpdateVehicle(v);
//		
		assertNotNull(vehicle);
		
	}
	@Test
	public void searchVehicleById()
	{
		Vehicle vehicle=daov.searchVehicleById(1002);
		//assertNotNull(vehicle);
		System.out.println(vehicle.getBrand());
	}
	@Test
	public void viewAllVehicle()
	{
		List<Vehicle> vehicle=daov.viewAllVehicles();
		for(Vehicle v:vehicle)
		{
			System.out.println(v.getBrand());
		}
	}
	@Test
	public void viewAllCustomerDetails()
	{
		Vehicle vehicle=daov.searchVehicleById(1002);
		Customer cust=vehicle.getCustomer();
		System.out.println(cust.getUserName()+" "+cust.getMailId()+" "+cust.getMobile());
	}

}
