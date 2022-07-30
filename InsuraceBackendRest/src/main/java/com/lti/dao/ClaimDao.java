package com.lti.dao;

import java.util.List;

import com.lti.entity.Claim;

public interface ClaimDao {

	Claim AddOrUpdateClaim(Claim claim);

	Claim searchClaimById(int claimId);

	List<Claim> viewAllClaims();
}
