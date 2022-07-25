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


}
