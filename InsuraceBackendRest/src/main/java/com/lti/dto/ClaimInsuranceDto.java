package com.lti.dto;

public class ClaimInsuranceDto {
	int userId;
	int insuranceId;
	int accountNo;
	int claimAmount;
	String reason;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
