package com.lti.dao;

import java.util.List;

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

	public InsuranceDocument searchInsuranceDocumentByInsuranceDocumentId(int insuranceDocumentId) {
		// TODO Auto-generated method stub
		return em.find(InsuranceDocument.class, insuranceDocumentId);
	}
//	public InsuranceDocument searchInsuranceDocumentByInsuranceId(int insuranceId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<InsuranceDocument> viewAllInsurancesDocuments() {
		// TODO Auto-generated method stub
		return em.createQuery("select id from InsuranceDocument id", InsuranceDocument.class).getResultList();
	}

}
