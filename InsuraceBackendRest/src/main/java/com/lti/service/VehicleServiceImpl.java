package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.VehicleInsuranceDao;
import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.exception.IdMissingException;
import com.lti.exception.InsuranceNotFound;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleInsuranceDao vehicleInsuranceDao;
	
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
