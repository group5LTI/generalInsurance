package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

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
	//tested
	@Test
	public void InsuranceDocumentAddTest() {
		InsuranceDocument id  = new InsuranceDocument();
		id.setInsuranceDocumentPath("Path/given/");
		Customer c = daoc.searchCustomer(104);
		Insurance i = daoi.searchInsurance(11002);
		id = i.getInsuranceDocument();
		if(i==null) {
		id.setCustomer(c);
		id.setInsurance(i);
		InsuranceDocument insuranceDocument = dao.addOrUpdateInsuranceDocument(id);
		assertNotNull(insuranceDocument);
		}
		else {
			System.out.println("Document already uploaded");
		}
		
		
		
	}
	//tested
	@Test
	public void viewAllInsuranceDocuments() {
		List<InsuranceDocument> lists = dao.viewAllInsurancesDocuments();
		assertNotEquals(0, lists.size());
	}
	//tested
	@Test
	public void searchInsuranceDocument() {
		InsuranceDocument id = dao.searchInsuranceDocumentByInsuranceDocumentId(12004);
		assertNotNull(id);
	}
	//tested
	@Test
	public void searchDocumentByInsuranceId() {
		Insurance i = daoi.searchInsurance(11003);
		InsuranceDocument id = i.getInsuranceDocument();
		if(id!=null) {
		System.out.println(id.getInsuranceDocumentId());
		}
		else {
			System.out.println("Document not uploaded yet");
		}
	}
	

}
