package com.lti.test;

import static org.junit.Assert.*;

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

	@Test
	public void customerAddTest() {
		Customer c  = new Customer();
		c.setLocation("Nerul");
		c.setMailId("abc@gmail.com");
		c.setMobile("9087654321");
		c.setPassword("pass@1243");
		c.setUserName("ABC");
		
		Customer customer = dao.addOrUpdateCustomer(c);
		assertNotNull(customer);
		
	}

}
