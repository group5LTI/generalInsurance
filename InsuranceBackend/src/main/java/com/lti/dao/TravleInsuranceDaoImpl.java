package com.lti.dao;

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

}
