package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Claim;
import com.lti.entity.Customer;

@Component
public class ClaimDaoImpl implements ClaimDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Claim AddOrUpdateClaim(Claim claim) {
		Claim claimPersisted = null;
		try {
			claimPersisted = em.merge(claim);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return claimPersisted;
	}

	public Claim searchClaimById(int claimId) {
		// TODO Auto-generated method stub
		return em.find(Claim.class, claimId);
	}

	public List<Claim> viewAllClaims() {
		// TODO Auto-generated method stub
		String jpql = "select cla from Claim cla";
		return em.createQuery(jpql).getResultList();
	}

}
