package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ClaimDocumentDto {

	private int claimId;
	private int userId;
	private MultipartFile claimInsuranceDocument;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public MultipartFile getClaimInsuranceDocument() {
		return claimInsuranceDocument;
	}
	public void setClaimInsuranceDocument(MultipartFile claimInsuranceDocument) {
		this.claimInsuranceDocument = claimInsuranceDocument;
	}
	
	
}
