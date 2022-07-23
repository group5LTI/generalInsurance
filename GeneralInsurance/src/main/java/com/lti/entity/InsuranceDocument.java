package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class InsuranceDocument {
	@Id
	@SequenceGenerator(name = "insurance_doc_seq" ,initialValue = 80000 ,allocationSize = 1)
	@GeneratedValue(generator="insurance_doc_seq",strategy = GenerationType.SEQUENCE)
	int insuranceDocumentId;
	String documentPath;
	
	@OneToOne
	@JoinColumn(name = "insuranceId")
	Insurance insurance;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	Customer customer;

	public int getInsuranceDocumentId() {
		return insuranceDocumentId;
	}

	public void setInsuranceDocumentId(int insuranceDocumentId) {
		this.insuranceDocumentId = insuranceDocumentId;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
	
}
