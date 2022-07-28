package com.lti.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.ClaimDao;
import com.lti.dao.ClaimDocumentDao;
import com.lti.entity.Claim;
import com.lti.entity.ClaimDocument;

public class ClaimDocumentTest {
	ClaimDocumentDao dao;
	ClaimDao daoc;
	

	@Before
	public void ClaimDocumentTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(ClaimDocumentDao.class);
		daoc = context.getBean(ClaimDao.class);

	}

	@Test
	public void AddClaimDocument() {
		ClaimDocument cd= new ClaimDocument();
		Claim c=daoc.searchClaimById(10020);
		
		cd.setClaim(c);
		cd.setClaimDocumentPath("C/Users");
		
		
		ClaimDocument claimDocument = dao.AddOrUpdateClaimDocument(cd);
		assertNotNull(claimDocument);
	
}
  
	 @Test
	public void searchClaimDocumentById() {
		ClaimDocument claimDocument=dao.searchClaimDoucmentById(9000);
		assertNotNull(claimDocument);
		System.out.println(claimDocument.getClaim().getAccountNo());
	 }
	 
	 @Test
	 public void viewAllClaimDocuments() {
		 List<ClaimDocument> lists = dao.viewAllClaimDocuments();
		 assertNotEquals(0, lists.size());
	 }
}
