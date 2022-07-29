package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	

	@PostMapping(value = "/buyvehicleinsurance")
	public String buyVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance) {
		String message = vehicleService.buyInsurance(vehicleInsurance);
		return message;
	}

	@PutMapping(value = "/renew")
	public RenewVehicleInsurance renewVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance) {
		RenewVehicleInsurance renewed = vehicleService.renewVehicleInsurance(vehicleInsurance);
		return renewed;
	}

	@PostMapping(value = "/registervehicleplan")
	public String registervehicleplan(@RequestBody VehicleInsurancePlan vehicleinsuranceplan) {

		String message = vehicleService.RegisterVehiclePlan(vehicleinsuranceplan);
		return message;
	}
	@PostMapping(value="/addvehicle")
	public String registervehicle(@RequestBody Vehicle vehicle) {
		String message = vehicleService.ResgisterVehicle(vehicle);
		return message;
		
	}

}
