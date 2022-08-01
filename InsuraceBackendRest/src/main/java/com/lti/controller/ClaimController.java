package com.lti.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimInsuranceDto;
import com.lti.entity.ClaimInurance;
import com.lti.entity.Insurance;
import com.lti.entity.TravelInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.exception.InsuranceNotFound;
import com.lti.service.ClaimService;
import com.lti.service.InsuranceService;
import com.lti.service.TravelService;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/claims")
@CrossOrigin(origins = "*")
public class ClaimController {

	@Autowired
	ClaimService claimservice;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	TravelService travelService;

	@RequestMapping(value = "/addclaimsignup", method = RequestMethod.POST)
	public String addclaimsignup(@RequestBody ClaimInsuranceDto claim) {
		ClaimInurance c = new ClaimInurance();
		c.setAccountNo(claim.getAccountNo());
		c.setApproval("Pending");
		c.setClaimAmount(claim.getClaimAmount());
		c.setClaimDate(LocalDate.now().toString());
		c.setReason(claim.getReason());
		c.setApprovedAmount(0);
		Insurance i = new Insurance();
		String message = "Error occurred";
		try {
		if(claim.getInsuranceId()>=7000) {
			VehicleInsurance v = vehicleService.searchVehicleInsuranceById(claim.getInsuranceId());
			if(v!=null) {
				i = v.getInsurance();
				c.setInsurance(i);
				if(v.getVehicle().getCustomer().getUserId()==claim.getUserId()) {
					message = claimservice.addclaimsignup(c);
					return message;
				}
				else {
					throw new InsuranceNotFound("No insurance found for this account");
				}
				
			}
			else {
				throw new InsuranceNotFound("No Insurance found");
			}
		}
		else if(claim.getInsuranceId()<6000) {
			TravelInsurance t = travelService.searchTravelInsuranceById(claim.getInsuranceId());
			if(t!=null) {
				i=t.getInsurance();
				c.setInsurance(i);
				System.out.println("Inside if ");
				message = claimservice.addclaimsignup(c);
				return message;
			}
			else {
				throw new InsuranceNotFound("No insuarnce Found");
			}
		}
		}
		catch (Exception e) {
			return e.getMessage();
		}
		return message;
	}

	@GetMapping(value = "/{claimId}")
	public ClaimInurance searchClaim(@PathVariable int claimId) {
		return claimservice.findClaim(claimId);
	}

	@GetMapping(value = "/viewAll")
	@ResponseBody
	public List<ClaimInurance> viewAllClaims() {
		return claimservice.viewAllClaim();
	}

}
