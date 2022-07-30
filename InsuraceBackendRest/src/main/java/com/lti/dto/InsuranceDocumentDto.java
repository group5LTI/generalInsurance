package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class InsuranceDocumentDto {

<<<<<<< HEAD
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
=======
	int vehicleInsuranceId;
	int customerId;
	MultipartFile insuranceDocument;
	public int getVehicleInsuranceId() {
		return vehicleInsuranceId;
	}
	public void setVehicleInsuranceId(int vehicleInsuranceId) {
		this.vehicleInsuranceId = vehicleInsuranceId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public MultipartFile getInsuranceDocument() {
		return insuranceDocument;
	}
	public void setInsuranceDocument(MultipartFile insuranceDocument) {
		this.insuranceDocument = insuranceDocument;
>>>>>>> 84c78046578fa07d8f6c9090d5c8a1b3dee8c8c2
	}
	
	
}
