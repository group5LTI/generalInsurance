package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_claim")
public class Claim {

	@Id
	@SequenceGenerator(name = "claim_seq",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "claim_seq",strategy = GenerationType.SEQUENCE)
	int claimId;
	
	String reason;
	int accountNo;
	double claimAmount;
	LocalDate claimDate;
	ApprovalType approval;
	double approvedAmount;
	
	@OneToOne(mappedBy = "claim")
	ClaimDocument claimDocument;
	
	@ManyToOne
	@JoinColumn(name = "claim_insurance_id")
	Insurance insurance;

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

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public ApprovalType getApproval() {
		return approval;
	}

	public void setApproval(ApprovalType approval) {
		this.approval = approval;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public ClaimDocument getClaimDocument() {
		return claimDocument;
	}

	public void setClaimDocument(ClaimDocument claimDocument) {
		this.claimDocument = claimDocument;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
	
	
	
	
	
	
}
