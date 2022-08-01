package com.lti.service;

import com.lti.entity.InsuranceDocument;

public interface InsuranceService {

	InsuranceDocument addOrUpdateInsuranceDocument(InsuranceDocument id);
	
	InsuranceDocument searchInsuranceDocumentByInsuranceId(int insuranceId);
	
	InsuranceDocument updateInsuranceDocument(InsuranceDocument id);
	
}
