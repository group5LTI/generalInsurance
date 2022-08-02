package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.ClaimInurance;
import com.lti.entity.Customer;

@Component
public class ClaimDaoImpl implements ClaimDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public ClaimInurance AddOrUpdateClaim(ClaimInurance claim) {
		ClaimInurance claimPersisted=null;
		try {
			claimPersisted = em.merge(claim);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return claimPersisted;
	}

	public ClaimInurance searchClaimById(int claimId) {
		// TODO Auto-generated method stub
		return em.find(ClaimInurance.class, claimId);
	}

	public List<ClaimInurance> viewAllClaims() {
		// TODO Auto-generated method stub
		String jpql = "select cla from Claim cla";
		return em.createQuery(jpql).getResultList();
	}

}
