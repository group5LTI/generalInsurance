package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.dto.TravelSearchDto;
import com.lti.entity.Customer;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.VehicleInsurancePlan;

@Component
public class TravlePlanDaoImpl implements TravelPlanDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public TravelInsurancePlan addOrUpdate(TravelInsurancePlan tp) {
		TravelInsurancePlan travelPlanPersisted = null;
		try {
			travelPlanPersisted = em.merge(tp);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return travelPlanPersisted;
	}

	public TravelInsurancePlan searchTravelPlanById(int travelPlanId) {
		// TODO Auto-generated method stub
		return em.find(TravelInsurancePlan.class, travelPlanId);
	}

	public List<TravelInsurancePlan> viewAllTravelPlans() {
		// TODO Auto-generated method stub
		return em.createQuery("select ti from TravelInsurancePlan ti", TravelInsurancePlan.class).getResultList();
	}

	@Override
	public TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType(TravelSearchDto dto1) {
		String jpql = "select tp from TravelInsurancePlan tp where tp.planType=:pType and tp.noOfPeople >=:p  and LOWER(tp.travelLocation)= LOWER(:loc) and tp.travleDuration>=:d";
        TypedQuery<TravelInsurancePlan> qry = em.createQuery(jpql, TravelInsurancePlan.class);
        qry.setParameter("pType", dto1.getPlanType());
        qry.setParameter("p", dto1.getNoOfPeople());
        qry.setParameter("loc", dto1.getLocation());
        qry.setParameter("d", dto1.getDuration());
		TravelInsurancePlan tip;
		try {
			tip=qry.getSingleResult();
		} catch (Exception e) {
			return null;
		}return tip;
	}

}
