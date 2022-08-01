package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dto.VehicleSearchDto;
import com.lti.entity.Customer;
import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.service.VehicleService;

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
	public VehicleInsurancePlan searchVehiclePlan(String vType, String pType ,int years) {
		// TODO Auto-generated method stub
		String jpql = "select vp from VehicleInsurancePlan vp where vp.vehicleType=:vType and vp.planType=:pType and vp.noOfYears=:years";
        TypedQuery<VehicleInsurancePlan> qry = em.createQuery(jpql, VehicleInsurancePlan.class);
        qry.setParameter("vType", vType);
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
	
//	@Override
//	public VehicleInsurancePlan searchPlanByVehicleTypeYear(VehicleSearchDto dto1) {
//		String jpql = "select vp from VehicleInsurancePlan vp where vp.planType=:vType and vp.noOfYears >=:p  and LOWER(tp.travelLocation)= LOWER(:loc) and tp.travleDuration>=:d";
//        TypedQuery<VehicleInsurancePlan> qry = em.createQuery(jpql,VehicleInsurancePlan.class);
//        qry.setParameter("vType", dto1.getVehicleType());
//        qry.setParameter("NoYear", dto1.getNoOfYears());
//        qry.setParameter("iType", dto1.getInsuranceType());
//		VehicleInsurancePlan vip;
//		try {
//			vip=qry.getSingleResult();
//		} catch (Exception e) {
//			return null;
//		}return vip;
//	}

//	@Override
//	public VehicleInsurancePlan searchPlanByDurationInsuranceType(String vehicleType, String insuranceType,
//			int planDuration) {
//		String jpql = "select vp from VehicleInsurancePlan vp where LOWER(vp.vehicleType)=LOWER(:vType) and LOWER(vp.insuranceType)=LOWER(:pType) and vp.noOfYears=:years";
//        TypedQuery<VehicleInsurancePlan> qry = em.createQuery(jpql, VehicleInsurancePlan.class);
//        qry.setParameter("vType", vehicleType);
//        qry.setParameter("pType", insuranceType);
//        qry.setParameter("years", planDuration);
////		return qry.C;
//        VehicleInsurancePlan vip;
//        try {
//            vip=qry.setMaxResults(1).getSingleResult();
//        } catch (Exception e) {
//        	System.out.println(e.getMessage());
//            return null;
//        }return vip;
//	}

	
	@Override
	public VehicleInsurancePlan searchPlanByDurationInsuranceType(String vehicleType, String insuranceType,
			int planDuration) {
		String jpql = "select vp from VehicleInsurancePlan vp where LOWER(vp.vehicleType)=LOWER(:vType) and LOWER(vp.insuranceType)=LOWER(:pType) and vp.noOfYears=:years";
        TypedQuery<VehicleInsurancePlan> qry = em.createQuery(jpql, VehicleInsurancePlan.class);
        qry.setParameter("vType", vehicleType);
        qry.setParameter("pType", insuranceType);
        qry.setParameter("years", planDuration);
//		return qry.C;
        VehicleInsurancePlan vip;
        try {
            vip=qry.setMaxResults(1).getSingleResult();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        }return vip;
	}

	@Override
	public VehicleInsurancePlan searchPlanByVehicleTypeYear(VehicleSearchDto dto1) {
		// TODO Auto-generated method stub
		return null;
	}
}