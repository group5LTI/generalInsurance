package com.lti.dto;

public class ViewUnverifiedDto {

	int claimId;
	String reason;
	int claimAmount;
	String claimDate;
	String approval;
	String claimDocumentPath;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getClaimDocumentPath() {
		return claimDocumentPath;
	}
	public void setClaimDocumentPath(String claimDocumentPath) {
		this.claimDocumentPath = claimDocumentPath;
	}
	
	
	
}
