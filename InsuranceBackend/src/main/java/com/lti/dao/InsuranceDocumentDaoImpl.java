package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.InsuranceDocument;

@Component
public class InsuranceDocumentDaoImpl implements InsuranceDocumentDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public InsuranceDocument addOrUpdateInsuranceDocument(InsuranceDocument insuranceDoument) {
		InsuranceDocument insuranceDocumentPersisted = null;
		try {
			insuranceDocumentPersisted = em.merge(insuranceDoument);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return insuranceDocumentPersisted;
	}

}
