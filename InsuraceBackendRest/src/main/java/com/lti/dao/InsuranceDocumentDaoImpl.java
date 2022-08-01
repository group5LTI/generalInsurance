package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.InsuranceDocument;
import com.lti.entity.VehicleInsurancePlan;

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

	@Override
	public InsuranceDocument searchInsuranceDocumentByInsuranceId(int id) {
		String jpql = "select i from InsuranceDocument i where i.insurance.insuranceId=:idd";
        TypedQuery<InsuranceDocument> qry = em.createQuery(jpql, InsuranceDocument.class);
        qry.setParameter("idd", id);
        InsuranceDocument idoc;
        try {
            idoc=qry.getSingleResult();
            return idoc;
        } catch (Exception e) {
            return null;
        }

	}

}
