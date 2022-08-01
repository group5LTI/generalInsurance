package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InsuranceDocumentDao;
import com.lti.entity.InsuranceDocument;
import com.lti.exception.CheckIdException;
import com.lti.exception.InsuranceNotFound;

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

	@Override
	public InsuranceDocument searchInsuranceDocumentByInsuranceId(int insuranceId) {
		// TODO Auto-generated method stub
		return insuranceDocumentDao.searchInsuranceDocumentByInsuranceId(insuranceId);
	}

	@Override
	public InsuranceDocument updateInsuranceDocument(InsuranceDocument id) {
		try {
			if(id.getInsurance().getInsuranceId()==0) {
				throw new CheckIdException("Check id you mentioned");}
			else if(insuranceDocumentDao.searchInsuranceDocumentByInsuranceId(id.getInsurance().getInsuranceId())==null)
				{throw new InsuranceNotFound("No insurance Found For this account");}
			InsuranceDocument id1 = insuranceDocumentDao.addOrUpdateInsuranceDocument(id);
			System.out.println("Indurance document updated");
			return id1;
		} catch (Exception e) {
			return null;
		}
	}

	
}
