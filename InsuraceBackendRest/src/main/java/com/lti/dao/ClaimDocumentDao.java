package com.lti.dao;

import java.util.List;

import com.lti.entity.Claim;
import com.lti.entity.ClaimDocument;

public interface ClaimDocumentDao {
	ClaimDocument AddOrUpdateClaimDocument(ClaimDocument claimDocument);

	ClaimDocument searchClaimDoucmentById(int claimDocumentId);

	List<ClaimDocument> viewAllClaimDocuments();
}
