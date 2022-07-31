package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InsuranceDao;
import com.lti.dao.VehicleDao;
import com.lti.dao.VehicleInsuranceDao;
import com.lti.dao.VehiclePlanDao;
import com.lti.dao.VehiclePlanDaoImpl;
import com.lti.dto.RenewVehicleInsurance;
import com.lti.dto.BuyVInsuranceDto;
import com.lti.dto.RenewVInsuranceDto;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.exception.IdMissingException;
import com.lti.exception.InsuranceNotFound;
import com.lti.exception.InsurancePlanNotFound;
import com.lti.exception.VehicleNotFound;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleInsuranceDao vehicleInsuranceDao;
	
	@Autowired 
	VehiclePlanDao vehiclePlanDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	InsuranceDao insuranceDao;
	
	@Override
	public VehicleInsurance buyInsurance(VehicleInsurance vehicleInsurance) {
		VehicleInsurance buyVehicleInsurance;
		try {
			buyVehicleInsurance = vehicleInsuranceDao.addOrUpdateVehicleInsurance(vehicleInsurance);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return buyVehicleInsurance;
	}
	@Override
	public RenewVehicleInsurance renewVehicleInsurance(RenewVInsuranceDto vehicleInsurance) {
		RenewVehicleInsurance dto = new RenewVehicleInsurance();
		try {
			if(vehicleInsurance.getVehicleInsuranceId()==0) {
				throw new IdMissingException("Enter Insurance ID");
			}
			else if (vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsurance.getVehicleInsuranceId())==null) {
				throw new InsuranceNotFound("Insurance record not found");
				
			}
			
			VehicleInsurance vehicleInsurance2 = vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsurance.getVehicleInsuranceId());
			VehicleInsurance update = vehicleInsuranceDao.addOrUpdateVehicleInsurance(vehicleInsurance2);
			dto.setMessage("Vehicle Insurance with Id:"+vehicleInsurance.getVehicleInsuranceId()+" renewed");
			dto.setVehicleInsurance(vehicleInsurance2);
			return dto;
		} catch (Exception e) {
			dto.setMessage(e.getMessage());
			return dto;
		}
	}
	
	@Override
	public String RegisterVehiclePlan(VehicleInsurancePlan vehicleInsurancePlan) {
		
		VehicleInsurancePlan vehicleinsplan;
		try {
			vehicleinsplan=vehiclePlanDao.addOrUpdateVehiclePlan(vehicleInsurancePlan);
		} catch (Exception e) {
			
			return e.getMessage();
		}
		return "Added successfully vehicleInsurancePlan vehicle plan Id: "+vehicleinsplan.getVehiclePlanId();
	}
	@Override //u
	public Vehicle ResgisterVehicle(Vehicle vehicle) {
		BuyVInsuranceDto dto = null;
		Vehicle vehicle1 = null;
		try {
			vehicle1=vehicleDao.addOrUpdateVehicle(vehicle);
			return vehicle1;
		} catch (Exception e) {
			return null;
		}
		
//		return "Vehicle Registered vehicleId "+vehicle1.getVehicleId();
	}
	@Override
	public VehicleInsurancePlan searchPlanById(int planId) {
		VehicleInsurancePlan vehiclePlan; 
		try {
			vehiclePlan = vehiclePlanDao.searchVehiclePlanById(planId);
		} catch (Exception e) {
			return null;
		}
		return vehiclePlan;
	}
	@Override
	public VehicleInsurancePlan searchPlanByDurationType(String vehicleType, String planType,int planDuration) {
		VehicleInsurancePlan vehiclePlan; 
		try {
			vehiclePlan = vehiclePlanDao.searchVehiclePlan(vehicleType, planType, planDuration);
		} catch (Exception e) {
			return null;
		}
		return vehiclePlan;
	}
	@Override
	public Insurance addVehicleInsurance(Insurance vi) {
		Insurance in;
		try {
			in = insuranceDao.addInsurance(vi);
			return in;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	

}
