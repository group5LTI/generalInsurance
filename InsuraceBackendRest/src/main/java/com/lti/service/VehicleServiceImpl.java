package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InsuranceDao;
import com.lti.dao.VehicleDao;
import com.lti.dao.VehicleInsuranceDao;
import com.lti.dao.VehiclePlanDao;
import com.lti.dao.VehiclePlanDaoImpl;

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
//	@Override
//	public boolean renewVehicleInsurance(RenewVInsuranceDto vehicleInsurance) {
//		RenewVehicleInsurance dto = new RenewVehicleInsurance();
//		try {
//			if(vehicleInsurance.getVehicleInsuranceId()==0) {
//				throw new IdMissingException("Enter Insurance ID");
//			}
//			else if (vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsurance.getVehicleInsuranceId())==null) {
//				throw new InsuranceNotFound("Insurance record not found");
//				
//			}
//			VehicleInsurance v = vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsurance.getVehicleInsuranceId());
//
//			return true;
//		} catch (Exception e) {
//			dto.setMessage(e.getMessage());
//			return false;
//		}
	// }

	@Override
	public String RegisterVehiclePlan(VehicleInsurancePlan vehicleInsurancePlan) {

		VehicleInsurancePlan vehicleinsplan;
		try {
			vehicleinsplan = vehiclePlanDao.addOrUpdateVehiclePlan(vehicleInsurancePlan);
		} catch (Exception e) {

			return e.getMessage();
		}
		return "Added successfully vehicleInsurancePlan vehicle plan Id: " + vehicleinsplan.getVehiclePlanId();
	}

	@Override // u
	public Vehicle ResgisterVehicle(Vehicle vehicle) {
		BuyVInsuranceDto dto = null;
		Vehicle vehicle1 = null;
		try {
			vehicle1 = vehicleDao.addOrUpdateVehicle(vehicle);
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
	public VehicleInsurancePlan searchPlanByDurationType(String vehicleType, String planType, int planDuration) {
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

	@Override
	public VehicleInsurance searchVehicleInsuranceById(int vehicleInsuranceId) {
		VehicleInsurance vi = vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsuranceId);
		return vi;
	}

	@Override
	public Vehicle searchVehicleByVehicleId(int vehicleId) {
		// TODO Auto-generated method stub
		return vehicleDao.searchVehicleById(vehicleId);
	}

	@Override
	public VehicleInsurancePlan searchPlanByDurationInsuranceType(String vehicleType, String insuranceType,
			int planDuration) {
		VehicleInsurancePlan vehiclePlan;
		try {
			vehiclePlan = vehiclePlanDao.searchPlanByDurationInsuranceType(vehicleType, insuranceType, planDuration);
		} catch (Exception e) {
			return null;
		}
		return vehiclePlan;
	}

	
	@Override
	public List<VehicleInsurance> viewAllVehicleInsurances() {
	
		return vehicleInsuranceDao.viewAllVehicleInsurance();
	}

	@Override
	public List<VehicleInsurance> viewAllVehicleInsurancesByUserId(int userId) {
		// TODO Auto-generated method stub
		return vehicleInsuranceDao.viewAllVehicleInsurancesByUserId(userId);
	}

	@Override
	public List<VehicleInsurance> viewAllVehicleInsurancesByUserName(String userName) {
		// TODO Auto-generated method stub
		return vehicleInsuranceDao.viewAllVehicleInsurancesByUserName(userName);
	}

	


}
