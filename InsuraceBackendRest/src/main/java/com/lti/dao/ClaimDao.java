package com.lti.dao;

import java.util.List;

import com.lti.dto.ClaimViewDto;
import com.lti.dto.ViewUnverifiedDto;
import com.lti.entity.ClaimInsurance;

public interface ClaimDao {

	ClaimInsurance AddOrUpdateClaim(ClaimInsurance claim);

	ClaimInsurance searchClaimById(int claimId);

	List<ClaimInsurance> viewAllClaims();

	List<ViewUnverifiedDto>viewAllUnverifiedClaims();

	boolean checkStatus(int claimId, String status);

	List<ClaimViewDto> viewClaimsUserName(int userIdd);
}
