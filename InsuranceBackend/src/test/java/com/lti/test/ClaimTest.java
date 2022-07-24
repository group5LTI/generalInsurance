package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.ClaimDao;
import com.lti.dao.InsuranceDao;
import com.lti.entity.ApprovalType;
import com.lti.entity.Claim;
import com.lti.entity.Insurance;

public class ClaimTest {
	
	ClaimDao dao;
	InsuranceDao daoi;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(ClaimDao.class);
		daoi = context.getBean(InsuranceDao.class);
	}

	@Test
	public void AddClaimTest() {
		Claim c = new Claim();
		c.setAccountNo(123456);
		c.setApproval(ApprovalType.Pending);
		c.setApprovedAmount(3000);
		c.setClaimAmount(6000);
		c.setClaimDate(LocalDate.of(2022, 7, 1));
		c.setReason("Timepass");
		
		Insurance i = daoi.searchInsurance(11000);
		c.setInsurance(i);
		
		Claim claim = dao.AddOrUpdateClaim(c);
		assertNotNull(claim);
	}

}
