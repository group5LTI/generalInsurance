package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tbl_insurancedocument")
public class InsuranceDocument {

	@Id
	@SequenceGenerator(name = "insurance_doc_seq",initialValue = 12000,allocationSize = 1)
	@GeneratedValue(generator = "insurance_doc_seq",strategy = GenerationType.SEQUENCE)
	int insuranceDocumentId;
	
	String insuranceDocumentPath;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@OneToOne
	@JoinColumn(name = "insuranceId")
	Insurance insurance;

	public int getInsuranceDocumentId() {
		return insuranceDocumentId;
	}

	public void setInsuranceDocumentId(int insuranceDocumentId) {
		this.insuranceDocumentId = insuranceDocumentId;
	}

	public String getInsuranceDocumentPath() {
		return insuranceDocumentPath;
	}

	public void setInsuranceDocumentPath(String insuranceDocumentPath) {
		this.insuranceDocumentPath = insuranceDocumentPath;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@JsonIgnore
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
	
}
