package com.lti.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.dto.BuyRegisterVInsuranceDto;
import com.lti.dto.BuyVInsuranceDto;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.service.CustomerService;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	CustomerService customerService;

	@PostMapping(value = "/buyvehicleinsurance")
	public boolean buyVehicleInsurance(@RequestBody BuyVInsuranceDto vehicleInsurance) {
		Vehicle reg = new Vehicle();
		reg.setBrand(vehicleInsurance.getVehicleBrand());
		reg.setChassisNumber(vehicleInsurance.getChassisNo());
		reg.setCustomer(customerService.findcustomerById(vehicleInsurance.getUserId()));
		reg.setDrivingLicence(vehicleInsurance.getdLicence());
		reg.setVehicleType(vehicleInsurance.getVehicleType());
		VehicleInsurancePlan vp = vehicleService.searchPlanByDurationType(vehicleInsurance.getVehicleType(),vehicleInsurance.getPlanType(), vehicleInsurance.getPlanDuration());
		if(vp!=null) {
			Vehicle vehicle = vehicleService.ResgisterVehicle(reg);
			if(vehicle!=null) {
				VehicleInsurance vi = new VehicleInsurance();
				vi.setVehicleInsurancePlan(vp);
				vi.setIssueDate(LocalDate.now().toString());
				vi.setVehicle(vehicle);
				vi.setAmountPaidV(vp.getPlannedAmountV());
				vi.setYears(vehicleInsurance.getPlanDuration());
				
				VehicleInsurance b = vehicleService.buyInsurance(vi);
				if(b!=null) {
					Insurance i = new Insurance();
					i.setVehicleInsurance(b);
					Insurance ins = vehicleService.addVehicleInsurance(i);
					System.out.println("Insurance Added InsuranceID : "+ins.getInsuranceId());
					return true;
				}
				else {
					System.out.println("Error while Adding insurance");
					return false;
				}
				}
			else {
				System.out.println("Error occured while registering");
				return false;
			}
		}
		else {
			System.out.println("Vehicle Plan not available");
			return false;
		}
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
//	@PostMapping(value="/addvehicle")
//	public Vehicle registervehicle(@RequestBody Vehicle vehicle) {
//		Vehicle  message = vehicleService.ResgisterVehicle(vehicle);
//		return message;
//		
//	}

}
