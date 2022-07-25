package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Customer;
import com.lti.entity.Insurance;

@Component
public class InsuranceDaoImpl implements InsuranceDao {
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Insurance addInsurance(Insurance insurance) {
		Insurance insurancePersisted = null;
		try {
			insurancePersisted = em.merge(insurance);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return insurancePersisted;
	}

	public Insurance searchInsurance(int insuranceId) {
		// TODO Auto-generated method stub
		return em.find(Insurance.class, insuranceId);
	}

}
