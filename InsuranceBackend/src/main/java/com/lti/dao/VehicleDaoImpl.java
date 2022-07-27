package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Customer;
import com.lti.entity.Vehicle;

@Component
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Vehicle addOrUpdateVehicle(Vehicle vehicle) {
		Vehicle vehiclePersisted = null;
		
				try {
					vehiclePersisted = em.merge(vehicle);
				} 
				catch (Exception e) {
					// TODO: handle exception
				}
				return vehiclePersisted;
	}

	public Vehicle searchVehicleById(int vehicleId) {
		// TODO Auto-generated method stub
		return em.find(Vehicle.class, vehicleId);
	}
	
	public List<Vehicle> viewAllVehicles() {
		String jpql="select v from Vehicle v";
		TypedQuery<Vehicle> query=em.createQuery(jpql,Vehicle.class);
		return query.getResultList();
		
	}

}
