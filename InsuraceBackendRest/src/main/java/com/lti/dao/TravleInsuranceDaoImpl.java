package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.entity.Customer;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.VehicleInsurance;

@Component
public class TravleInsuranceDaoImpl implements TravelInsuranceDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CustomerDao daoc;
	
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

	@Override
	public List<TravelInsurance> viewAllTravelInsurancesByUserName(String uname) {
		Customer c = daoc.searchCustomerByUsername(uname);
		int userId = c.getUserId();
		String jpql = "select vp from TravelInsurance vp where vp.customer.userId=:uid";
        TypedQuery<TravelInsurance> qry = em.createQuery(jpql, TravelInsurance.class);
        qry.setParameter("uid", userId);
//		return qry.C;
        try {
        	List<TravelInsurance> vp = qry.getResultList();
        	return vp;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        }
	}



}
