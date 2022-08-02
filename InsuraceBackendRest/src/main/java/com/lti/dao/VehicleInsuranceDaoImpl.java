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
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

@Component
public class VehicleInsuranceDaoImpl implements VehicleInsuranceDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	VehiclePlanDao dao;
	
	@Autowired
	CustomerDao daoc;
	
	@Transactional
	public VehicleInsurance addOrUpdateVehicleInsurance(VehicleInsurance vehicleInsurance) {
		VehicleInsurance vehicleInsurancePersisted = null;
		try {
			vehicleInsurancePersisted = em.merge(vehicleInsurance);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return vehicleInsurancePersisted;
	}

	public VehicleInsurance searchVehicleInsuraceById(int vehicleInsuranceId) {
		// TODO Auto-generated method stub
		return em.find(VehicleInsurance.class, vehicleInsuranceId);
	}
	public List<VehicleInsurance> viewAllVehicleInsurance() {
		// TODO Auto-generated method stub
		return em.createQuery("select vi from VehicleInsurance vi", VehicleInsurance.class).getResultList();
	}

	@Override
	public List<VehicleInsurance> viewAllVehicleInsurancesByUserName(String userName) {
		// TODO Auto-generated method stub
		Customer c = daoc.searchCustomerByUsername(userName);
		int userId = c.getUserId();
		String jpql = "select vp from VehicleInsurance vp where vp.vehicle.customer.userId=:uid";
        TypedQuery<VehicleInsurance> qry = em.createQuery(jpql, VehicleInsurance.class);
        qry.setParameter("uid", userId);
//		return qry.C;
        try {
        	List<VehicleInsurance> vp = qry.getResultList();
        	return vp;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        }
	}

	@Override
	public List<VehicleInsurance> viewAllVehicleInsurancesByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> viewAllVehicleInsurancesIdByUserName(String uname) {
		Customer c = daoc.searchCustomerByUsername(uname);
		int userId = c.getUserId();
		String jpql = "select vp.vehicleInsuranceId from VehicleInsurance vp where vp.vehicle.customer.userId=:uid";
        TypedQuery<Integer> qry = em.createQuery(jpql, Integer.class);
        qry.setParameter("uid", userId);
//		return qry.C;
        try {
        	List<Integer> vp = qry.getResultList();
        	return vp;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        }
	}


	


}
