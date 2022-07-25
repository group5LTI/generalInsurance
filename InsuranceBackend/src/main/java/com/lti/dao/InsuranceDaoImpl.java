package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	public List<Insurance> viewAllInsurances() {
		// TODO Auto-generated method stub
		return em.createQuery("select i from Insurance i", Insurance.class).getResultList();
	}

	public Insurance searchInsuranceByVehicleInsuranceId(int vehicleInsuranceId) {
		// TODO Auto-generated method stub
		String jpql="select i from Insurance i where i.vehicleinsuranceid=:vid";
		Query query=em.createQuery(jpql);
		query.setParameter("vid", vehicleInsuranceId);
		return em.createQuery(jpql, Insurance.class).getSingleResult();
	}

	public Insurance searchInsuranceByTravelInsuranceId(int travelInsuranceId) {
		// TODO Auto-generated method stub
		String jpql="select i from Insurance i where i.travelInsuranceId=:tid";
		Query query=em.createQuery(jpql);
		query.setParameter("tid", travelInsuranceId);
		return em.createQuery(jpql, Insurance.class).getSingleResult();
	}

}
