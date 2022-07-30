package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins="*")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value="/buyvehicleinsurance")
	public String buyVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance) {
		String message = vehicleService.buyInsurance(vehicleInsurance);
		return message;
	}
	@RequestMapping(value="/renew")
	public RenewVehicleInsurance renewVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance) {
		RenewVehicleInsurance renewed = vehicleService.renewVehicleInsurance(vehicleInsurance);
		return renewed;
	}
	
}
