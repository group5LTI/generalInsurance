package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ClaimDao;
import com.lti.entity.ClaimInurance;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimDao claimDao;

	@Override
	public String addclaimsignup(ClaimInurance claim) {
		ClaimInurance claim2;
		try {
			System.out.println(claim.getInsurance().getInsuranceId());
			claim2 = claimDao.AddOrUpdateClaim(claim);
			return "Your claimId is added with this claimId : " + claim2.getClaimId();
		} catch (Exception e) {
			System.out.println("Inside sevice");
			return e.getMessage();
		}
	}
	@Override
	public ClaimInurance findClaim(int claimId) {
		return claimDao.searchClaimById(claimId);
	}
	@Override
	public List<ClaimInurance> viewAllClaim() {
		return claimDao.viewAllClaims();
	}

	// public boolean ClaimLogin(int ClaimId, String password) {

	// return claimDao.login(ClaimId,password);
	// }
}
