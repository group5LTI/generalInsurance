package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InsuranceDocumentDao;
import com.lti.entity.InsuranceDocument;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceDocumentDao insuranceDocumentDao;
	
	@Override
	public InsuranceDocument addOrUpdateInsuranceDocument(InsuranceDocument id) {
		InsuranceDocument id1;
		try {
			id1 = insuranceDocumentDao.addOrUpdateInsuranceDocument(id);
			return id1; 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
