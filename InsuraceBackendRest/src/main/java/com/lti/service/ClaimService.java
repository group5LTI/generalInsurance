package com.lti.service;

import java.util.List;

import com.lti.entity.ClaimInurance;

public interface ClaimService {
	
	String addclaimsignup(ClaimInurance claim);
	
    ClaimInurance findClaim(int claimId);
    
    List<ClaimInurance> viewAllClaim();

}
