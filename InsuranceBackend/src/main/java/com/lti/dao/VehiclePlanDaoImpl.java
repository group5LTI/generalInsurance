package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.VehicleInsurancePlan;

@Component
public class VehiclePlanDaoImpl implements VehiclePlanDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public VehicleInsurancePlan addOrUpdateVehiclePlan(VehicleInsurancePlan vip) {
		VehicleInsurancePlan vehiclePlanPersisted = null;
		try {
			vehiclePlanPersisted = em.merge(vip);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return vehiclePlanPersisted;
	}

	public VehicleInsurancePlan searchVehiclePlan(int vehiclePlanId) {
		// TODO Auto-generated method stub
		return em.find(VehicleInsurancePlan.class, vehiclePlanId);
	}

}
