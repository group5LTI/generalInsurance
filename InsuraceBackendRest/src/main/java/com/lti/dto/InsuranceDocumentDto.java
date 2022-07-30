package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class InsuranceDocumentDto {

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
	}
	
	
}
