package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class InsuranceDocumentDto {

	private int insuranceId;
	private MultipartFile document;
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public MultipartFile getDocument() {
		return document;
	}
	public void setDocument(MultipartFile document) {
		this.document = document;

	}
	
	
}
