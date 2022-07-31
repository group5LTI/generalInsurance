package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.entity.TravelInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;

@Component
public class VehicleInsuranceDaoImpl implements VehicleInsuranceDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	VehiclePlanDao dao;
	
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
	public List<VehicleInsurance> viewAllVehicleInsuranceByName(String userName) {
	
		return null;
	}

}
