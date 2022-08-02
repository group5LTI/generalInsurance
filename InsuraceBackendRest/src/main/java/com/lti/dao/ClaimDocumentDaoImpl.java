package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.InsuranceDocument;
import com.lti.entity.ClaimDocument;

@Component
public class ClaimDocumentDaoImpl implements ClaimDocumentDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public ClaimDocument AddOrUpdateClaimDocument(ClaimDocument claimDocument) {
		ClaimDocument claimDocumentPersisted = null;
		try {
			claimDocumentPersisted = em.merge(claimDocument);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return claimDocumentPersisted;
	}

	public ClaimDocument searchClaimDoucmentById(int claimDocumentId) {
		// TODO Auto-generated method stub
		return em.find(ClaimDocument.class, claimDocumentId);
	}

	public List<ClaimDocument> viewAllClaimDocuments() {
		// TODO Auto-generated method stub
		String jpql = "select cla from ClaimDocument cla";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public ClaimDocument searchClaimDoucmentByClaimId(int insIdUpload) {
		String jpql = "select i from ClaimDocument i where i.claiminsurance.claimId=:idd";
        TypedQuery<ClaimDocument> qry = em.createQuery(jpql, ClaimDocument.class);
        qry.setParameter("idd", insIdUpload);
        ClaimDocument idoc;
        try {
            idoc=qry.getSingleResult();
            return idoc;
        } catch (Exception e) {
            return null;
        }
	}

}
