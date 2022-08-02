package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class InsuranceDocumentDto {

	private int insuranceId;
	private int userId;
	private MultipartFile insuranceDocument;
	
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MultipartFile getInsuranceDocument() {
		return insuranceDocument;
	}
	public void setInsuranceDocument(MultipartFile insuranceDocument) {
		this.insuranceDocument = insuranceDocument;
	}
	
	
	
}
