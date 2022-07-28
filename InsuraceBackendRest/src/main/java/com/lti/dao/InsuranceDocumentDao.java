package com.lti.dao;

import java.util.List;

import com.lti.entity.InsuranceDocument;

public interface InsuranceDocumentDao {

	InsuranceDocument addOrUpdateInsuranceDocument(InsuranceDocument insuranceDoument);
	
	InsuranceDocument searchInsuranceDocumentByInsuranceDocumentId(int insuranceDocumentId);
	
//	InsuranceDocument searchInsuranceDocumentByInsuranceId(int insuranceId);
	
	List<InsuranceDocument> viewAllInsurancesDocuments();
}
