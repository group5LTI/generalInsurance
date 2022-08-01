package com.lti.controller;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BuyTInsuranceDto;
import com.lti.dto.ReturnMessageWhileBuying;
import com.lti.dto.TravelSearchDto;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.TravelInsurance;
import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.exception.InsurancePlanNotFound;
import com.lti.exception.RegistrationError;
import com.lti.service.CustomerService;
import com.lti.service.TravelService;

@RestController
@RequestMapping("/travel")
@CrossOrigin(origins = "*")
public class TravelController {

	@Autowired
	TravelService travelService;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/buytravelinsurance")
	public ReturnMessageWhileBuying buyTravelInsurance(@RequestBody BuyTInsuranceDto travelInsurance) {
		TravelInsurance travelIn = new TravelInsurance();
		TravelSearchDto trdto = new TravelSearchDto();
		ReturnMessageWhileBuying returnMessage = new ReturnMessageWhileBuying();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(travelInsurance.getTravelEndDate());
		LocalDate end = LocalDate.parse(travelInsurance.getTravelEndDate(),formatter);
		LocalDate start = LocalDate.parse(travelInsurance.getTravelStartDate(),formatter);
		Period months = Period.between(start, end);
		int month = (int)((months.getYears()*12)+months.getMonths()+(int)(months.getDays()/12));
		System.out.println("Months ="+month);
		String planType =travelInsurance.getPlanType();
		System.out.println("Plan type"+planType);
		int people =travelInsurance.getNoOfPeople();
		System.out.println("No of people "+people);
		String location =travelInsurance.getLocation();
		System.out.println("Location :"+location);
		TravelInsurancePlan trp = travelService.searchPlanByPeoplePlanLocationDurationType(planType,people,location,month);
		try {
			if(trp!=null) {
				travelIn.setAmountPaid(trp.getPlannedAmount());
				TravelInsurance ti =new TravelInsurance();
				Customer c = customerService.findcustomerById(travelInsurance.getUserId());
				travelIn.setCustomer(c);
				travelIn.setLocation(travelInsurance.getLocation());
				travelIn.setTravelEndDate(travelInsurance.getTravelEndDate());
				travelIn.setTravelStartDate(travelInsurance.getTravelStartDate());
				travelIn.setTravelInsurancePlan(trp);
				travelIn.setNoOfPeople(travelInsurance.getNoOfPeople());
				ti = travelService.buyTravelInsurance(travelIn);
				if(ti!=null) {
					Insurance insurance = new Insurance();
					insurance.setTravelInsurance(ti);
					Insurance i = travelService.addTravelInsurance(insurance);
					TravelInsurance travel = travelService.searchTravelInsuranceById(ti.getTravelInsuranceId());
					travel.setInsurance(i);
					returnMessage.setValid(true);
					returnMessage.setMessage("Congratulations You have bought "+ti.getTravelInsurancePlan().getPlanType()+"and no of people travelling "+ti.getNoOfPeople());
					return returnMessage;
				}
				else {
					throw new RegistrationError("Travel Registration Error");
				}
			}
			else {
				throw new InsurancePlanNotFound("Insurance Plan not available for this location");
			
			}
		} catch (Exception e) {
			returnMessage.setMessage(e.getMessage());
			returnMessage.setValid(false);
			return returnMessage;
		}
		
	}
	
	@PostMapping(value = "/registertravelplan")
	public String registerTravelPlan(@RequestBody TravelInsurancePlan travelInsurancePlan) {
		return travelService.RegisterTravelPlan(travelInsurancePlan);
	}

//	@GetMapping(value="/searchbytype")
//	public TravelInsurancePlan searchByDto(@RequestBody TravelSearchDto travelSearchDto) {
//	return travelService.searchPlanByPeoplePlanLocationDurationType(travelSearchDto);
//	}
	
	
//	@GetMapping(value="/searchbytype")
//	public TravelInsurancePlan searchByDto(@RequestBody TravelSearchDto travelSearchDto) {
//		
//	return travelService.searchPlanByPeoplePlanLocationDurationType(travelSearchDto);
//	}
//	
	
//	@GetMapping(value="/CalTravel")
//		public TravelInsurancePlan searchPlanByPeoplePlanLocationDurationType1(@RequestParam TravelSearchDto travelInsurance) {
//			
//			
//			String msg="passed";
//			int month = travelInsurance.getDuration();
//			System.out.println("DrurationMonths ="+month);
//			String planType =travelInsurance.getPlanType();
//			System.out.println("Plan type"+planType);
//			int people =travelInsurance.getNoOfPeople();
//			System.out.println("No of people "+people);
//			String location =travelInsurance.getLocation();
//			System.out.println("Location :"+location);
//			TravelInsurancePlan trp = travelService.searchPlanByPeoplePlanLocationDurationType(planType,people,location,month);
//			try {
//				if(trp!=null) {
//					System.out.println("Sucuss");
//				}else {
//					throw new InsurancePlanNotFound("No Plan found here");
//					
//				}
//				}
//				catch (Exception e) {
//					System.out.println("fail");
//					return trp;
//				}
//			
//			return trp;
//			 
//		}}
//	


	
//	@GetMapping(value="/calVehicle")
//	public VehicleInsurancePlan searchVehiclePlan(@RequestParam("planId") int VplanId ) {
//		return vehicleService.searchPlanById(VplanId);
//	}
}
