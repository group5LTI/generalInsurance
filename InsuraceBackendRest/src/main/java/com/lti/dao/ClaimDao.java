package com.lti.dao;

import java.util.List;

import com.lti.entity.ClaimInurance;

public interface ClaimDao {

	ClaimInurance AddOrUpdateClaim(ClaimInurance claim);

	ClaimInurance searchClaimById(int claimId);

	List<ClaimInurance> viewAllClaims();
}
