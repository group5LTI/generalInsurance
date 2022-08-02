package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_claimdocument")
public class ClaimDocument {
	
	@Id
	@SequenceGenerator(name = "claim_doc_seq",initialValue = 9000,allocationSize = 1)
	@GeneratedValue(generator = "claim_doc_seq",strategy = GenerationType.SEQUENCE)
	int claimDocumentId;
	String claimDocumentPath;
	
	@OneToOne
	@JoinColumn(name = "claim_id")
	ClaimInsurance claiminsurance;

	public int getClaimDocumentId() {
		return claimDocumentId;
	}

	public void setClaimDocumentId(int claimDocumentId) {
		this.claimDocumentId = claimDocumentId;
	}

	public String getClaimDocumentPath() {
		return claimDocumentPath;
	}

	public void setClaimDocumentPath(String claimDocumentPath) {
		this.claimDocumentPath = claimDocumentPath;
	}

	public ClaimInsurance getClaiminsurance() {
		return claiminsurance;
	}

	public void setClaiminsurance(ClaimInsurance claiminsurance) {
		this.claiminsurance = claiminsurance;
	}

	
	
	
	

}
