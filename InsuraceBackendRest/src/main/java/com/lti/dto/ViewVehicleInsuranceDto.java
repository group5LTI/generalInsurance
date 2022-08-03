package com.lti.dto;

public class ViewVehicleInsuranceDto {
	int vehicleInsuranceId;
	String issueDate;
	int years;
	double amountPaidV;
	String insuranceType;
	public int getVehicleInsuranceId() {
		return vehicleInsuranceId;
	}
	public void setVehicleInsuranceId(int vehicleInsuranceId) {
		this.vehicleInsuranceId = vehicleInsuranceId;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public double getAmountPaidV() {
		return amountPaidV;
	}
	public void setAmountPaidV(double amountPaidV) {
		this.amountPaidV = amountPaidV;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	
	

}
