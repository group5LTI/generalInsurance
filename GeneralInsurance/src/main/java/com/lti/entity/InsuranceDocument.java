package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InsuranceDocument {
	@Id
	@SequenceGenerator(name = "insurance_doc_seq" , ,allocationSize = 1)
	int insuranceDocumentId;
	String documentPath;
	
	
	
}
