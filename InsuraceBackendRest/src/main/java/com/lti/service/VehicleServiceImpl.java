package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.VehicleInsuranceDao;
import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.exception.IdMissingException;
import com.lti.exception.InsuranceNotFound;
import com.lti.exception.InsurancePlanNotFound;
import com.lti.exception.VehicleNotFound;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleInsuranceDao vehicleInsuranceDao;
	
	@Override
	public String buyInsurance(VehicleInsurance vehicleInsurance) {
		VehicleInsurance buyVehicleInsurance;
		try {
			buyVehicleInsurance = vehicleInsuranceDao.addOrUpdateVehicleInsurance(vehicleInsurance);
			if(buyVehicleInsurance.getVehicle()==null) {
				throw new VehicleNotFound("No vehicle Found");
			}
			else if (buyVehicleInsurance.getVehicleInsurancePlan()==null) {
				
				throw new InsurancePlanNotFound("No plan available");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Congratulations! Your Vehicle insurance Id is:"+vehicleInsurance.getVehicleInsuranceId();
	}
	@Override
	public RenewVehicleInsurance renewVehicleInsurance(VehicleInsurance vehicleInsurance) {
		RenewVehicleInsurance dto = new RenewVehicleInsurance();
		try {
			if(vehicleInsurance.getVehicleInsuranceId()==0) {
				throw new IdMissingException("Enter Insurance ID");
			}
			else if (vehicleInsuranceDao.searchVehicleInsuraceById(vehicleInsurance.getVehicleInsuranceId())==null) {
				throw new InsuranceNotFound("Insurance record not found");
				
			}
			VehicleInsurance vehicleInsurance2 = vehicleInsuranceDao.addOrUpdateVehicleInsurance(vehicleInsurance);
			dto.setMessage("Vehicle Insurance with Id:"+vehicleInsurance.getVehicleInsuranceId()+" renewed");
			dto.setVehicleInsurance(vehicleInsurance2);
			return dto;
		} catch (Exception e) {
			dto.setMessage(e.getMessage());
			return dto;
		}
	}

	

}
