package com.lti.service;

import java.util.List;

import com.lti.dto.ClaimDto;
import com.lti.dto.ClaimViewDto;
import com.lti.dto.UpdateCustomer;
import com.lti.dto.ViewUnverifiedDto;
import com.lti.entity.ClaimDocument;
import com.lti.entity.ClaimInsurance;

public interface ClaimService {
	
	ClaimInsurance addclaimsignup(ClaimInsurance claim);
	
    ClaimInsurance findClaim(int claimId);
    
    List<ClaimInsurance> viewAllClaim();

	ClaimDto updateClaimInsurance(ClaimInsurance claim);

	ClaimDocument addOrUpdateClaimDocument(ClaimDocument cd);

	ClaimDocument searchClaimDocumentByClaimId(int insIdUpload);

	ClaimDocument updateClaimInsuranceDocument(ClaimDocument idoc);

	List<ViewUnverifiedDto> viewAllUnverifiedClaim();

	boolean checkStatus(int claimId,String status);

	List<ClaimViewDto> viewClaimsUserName(int userIdd);
}
