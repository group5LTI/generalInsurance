package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

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

		Insurance i = daoi.searchInsurance(11003);
		c.setInsurance(i);

		Claim claim = dao.AddOrUpdateClaim(c);
		assertNotNull(claim);
	}

	@Test
	public void searchClaimById() {
		Claim claim = dao.searchClaimById(10020);
		assertNotNull(claim);
		System.out.println(claim.getClaimId());
	}

	@Test
	public void viewAllClaims() {

		List<Claim> claims = dao.viewAllClaims();
		assertFalse(claims.isEmpty());
		for (Claim c : claims) {
			System.out.println(c.getAccountNo());

		}
	}
}
