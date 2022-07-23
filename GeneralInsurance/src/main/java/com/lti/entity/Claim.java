package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Claim {

	@Id
	@SequenceGenerator(name = "claim_seq", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "claim_seq", strategy = GenerationType.SEQUENCE)
	
	int claimId;
	String reason;
	int accountNumber;
	double claimAmount;
	LocalDate claimDate;
	String approval;
	double approvalAmount;
	
	@ManyToOne
	@JoinColumn(name = "insuranceId")
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

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public double getApprovalAmount() {
		return approvalAmount;
	}

	public void setApprovalAmount(double approvalAmount) {
		this.approvalAmount = approvalAmount;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
}
