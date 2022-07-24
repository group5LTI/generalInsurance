package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.InsuranceDao;
import com.lti.dao.InsuranceDocumentDao;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.InsuranceDocument;

public class InsuranceDocumentTest {
	InsuranceDocumentDao dao;
	CustomerDao daoc;
	InsuranceDao daoi;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(InsuranceDocumentDao.class);
		daoc = context.getBean(CustomerDao.class);
		daoi = context.getBean(InsuranceDao.class);
	}

	@Test
	public void InsuranceDocumentAddTest() {
		InsuranceDocument id  = new InsuranceDocument();
		id.setInsuranceDocumentPath("Path/given/");
		Customer c = daoc.searchCustomer(100);
		Insurance i = daoi.searchInsurance(11000);
		id.setCustomer(c);
		id.setInsurance(i);
		InsuranceDocument insuranceDocument = dao.addOrUpdateInsuranceDocument(id);
		assertNotNull(insuranceDocument);
		
		
	}

}
