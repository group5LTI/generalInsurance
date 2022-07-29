package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Customer;
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

	public VehicleInsurancePlan searchVehiclePlanById(int vehiclePlanId) {
		// TODO Auto-generated method stub
		return em.find(VehicleInsurancePlan.class, vehiclePlanId);
	}
	
	public List<VehicleInsurancePlan> viewAllVehicleInsurancePlans() {
		// TODO Auto-generated method stub
		return em.createQuery("select vip from VehicleInsurancePlan vip", VehicleInsurancePlan.class).getResultList();
	}

	@Override
	public VehicleInsurancePlan searchVehiclePlan(String vType, String iType, String pType ,int years) {
		// TODO Auto-generated method stub
		String jpql = "select vp from VehicleInsurancePlan vp where vp.vehicleType=:vType and vp.insuranceType=:iType and vp.planType=:pType and vp.noOfYears=:years";
        TypedQuery<VehicleInsurancePlan> qry = em.createQuery(jpql, VehicleInsurancePlan.class);
        qry.setParameter("vType", vType);
        qry.setParameter("iType", iType);
        qry.setParameter("pType", pType);
        qry.setParameter("years", years);
//		return qry.C;
        VehicleInsurancePlan vip;
        try {
            vip=qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }return vip;

	}

}
