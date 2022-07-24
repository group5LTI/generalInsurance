package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.TravelInsurance;
import com.lti.entity.VehicleInsurance;

@Component
public class VehicleInsuranceDaoImpl implements VehicleInsuranceDao {

	@PersistenceContext
	EntityManager em;
	
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

}
