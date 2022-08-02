package com.lti.dao;

import java.util.List;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.ClaimDocument;

public interface ClaimDocumentDao {
	ClaimDocument AddOrUpdateClaimDocument(ClaimDocument claimDocument);

	ClaimDocument searchClaimDoucmentById(int claimDocumentId);

	List<ClaimDocument> viewAllClaimDocuments();

	ClaimDocument searchClaimDoucmentByClaimId(int insIdUpload);

	
}
