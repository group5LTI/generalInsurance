package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.CustomerDaoImpl;
import com.lti.entity.Customer;
import com.lti.entity.Vehicle;


public class CustomerTest {
	
CustomerDao dao;
	
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
	dao = context.getBean(CustomerDao.class);
	}
	//tested
	@Test
	public void customerAddTest() {
		Customer c  = new Customer();
		c.setLocation("Thane");
		c.setMailId("john@gmail.com");
		c.setMobile("1234567890");
		c.setPassword("pass@4567");
		c.setUserName("John");
		
		Customer customer = dao.addOrUpdateCustomer(c);
		assertNotNull(customer);
		
	}
	@Test
	public void searchCustomerById()
	{
		Customer customer=dao.searchCustomer(104);
		assertNotNull(customer);
		System.out.println(customer.getUserName());
	}

	@Test
	public void viewallCustomers()
	{
		List<Customer> customer=dao.viewAllCustomers();
		for(Customer c:customer)
		{
			System.out.println(c.getUserName());
		}
	}
	@Test
	public void login()
	{
		boolean b=dao.login(100, "pass@1243");
		assertTrue(b);
	}

	@Test
	public void viewVehicleDetails()
	{
		Customer customer=dao.searchCustomer(104);
		List<Vehicle> veh=customer.getVehicles();
		for(Vehicle v:veh)
		{
			System.out.println(v.getDrivinglicence()+" "+v.getBrand()+" "+v.getChassisNumber());
		}
	}
}
