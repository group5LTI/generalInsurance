package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;

@Component
public class TravleInsuranceDaoImpl implements TravelInsuranceDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public TravelInsurance addOrUpdateTravelInsurance(TravelInsurance travelInsurance) {
		TravelInsurance travelInsurancePersisted = null;
		try {
			travelInsurancePersisted = em.merge(travelInsurance);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return travelInsurancePersisted;
	}

	public TravelInsurance searchTravelInsuranceById(int travelInsuranceId) {
		// TODO Auto-generated method stub
		return em.find(TravelInsurance.class, travelInsuranceId);
	}

	public List<TravelInsurance> viewAllTravelInsurances() {
		// TODO Auto-generated method stub
		return em.createQuery("select t from TravelInsurance t", TravelInsurance.class).getResultList();
	}



}
