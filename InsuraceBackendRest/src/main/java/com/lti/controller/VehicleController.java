package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RenewVehicleInsurance;
import com.lti.dto.BuyRegisterVInsuranceDto;
import com.lti.dto.BuyVInsuranceDto;
import com.lti.dto.InsuranceDocumentDto;
import com.lti.dto.RenewVInsuranceDto;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.InsuranceDocument;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.exception.InsurancePlanNotFound;
import com.lti.exception.RegistrationError;
import com.lti.service.CustomerService;
import com.lti.service.InsuranceService;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	CustomerService customerService;

	@Autowired
	InsuranceService insuranceService;

	@PostMapping(value = "/buyvehicleinsurance")
	public boolean buyVehicleInsurance(@RequestBody BuyVInsuranceDto vehicleInsurance) {

		Vehicle reg = new Vehicle();
		reg.setBrand(vehicleInsurance.getVehicleBrand());
		reg.setChassisNumber(vehicleInsurance.getChassisNo());
		reg.setCustomer(customerService.findcustomerById(vehicleInsurance.getUserId()));
		reg.setDrivingLicence(vehicleInsurance.getdLicence());
		reg.setVehicleType(vehicleInsurance.getVehicleType());
		VehicleInsurancePlan vp = vehicleService.searchPlanByDurationType(vehicleInsurance.getVehicleType(),
				vehicleInsurance.getPlanType(), vehicleInsurance.getPlanDuration());
		try {
			if (vp != null) {
				Vehicle vehicle = vehicleService.ResgisterVehicle(reg);
				if (vehicle != null) {
					VehicleInsurance vi = new VehicleInsurance();
					vi.setVehicleInsurancePlan(vp);
					vi.setIssueDate(LocalDate.now().toString());
					vi.setVehicle(vehicle);
					vi.setAmountPaidV(vp.getPlannedAmountV());
					vi.setYears(vehicleInsurance.getPlanDuration());

					VehicleInsurance b = vehicleService.buyInsurance(vi);
					if (b != null) {
						return true;
					} else {

						throw new RegistrationError("Error while Adding insurance");
					}
				} else {
					throw new RegistrationError("Registration of Vehicle Failed");
				}
			} else {
				throw new InsurancePlanNotFound("No Plan found here");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@PutMapping(value = "/renew")
	public boolean renewVehicleInsurance(@RequestBody RenewVInsuranceDto vehicleInsurance) {
//		boolean renewed = vehicleService.renewVehicleInsurance(vehicleInsurance);
		VehicleInsurance v = vehicleService.searchVehicleInsuranceById(vehicleInsurance.getVehicleInsuranceId());
		VehicleInsurancePlan vp = vehicleService.searchPlanByDurationType(v.getVehicle().getVehicleType(),
				vehicleInsurance.getPlanType(), vehicleInsurance.getPlanDuration());
		try {
			if (vp != null) {
				v.setVehicleInsurancePlan(vp);
				VehicleInsurance vp1 = vehicleService.buyInsurance(v);
				if (vp != null) {
					return true;
				} else {
					throw new RegistrationError("Error while renewing Insurance");
				}
			} else {
				throw new InsurancePlanNotFound("No plan available");
			}
		} catch (Exception e) {
			return false;
		}

	}

	@PostMapping(value = "/registervehicleplan")
	public String registervehicleplan(@RequestBody VehicleInsurancePlan vehicleinsuranceplan) {

		String message = vehicleService.RegisterVehiclePlan(vehicleinsuranceplan);
		return message;
	}

	@PostMapping(value = "/upload-document")
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.ALL_VALUE ,value = "/upload-document")
	public String uploadDocument(@RequestBody InsuranceDocumentDto dto) {

		String imageUploadLocation = "c:/uploads/";
		String fileName = dto.getDocument().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(dto.getDocument().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			return e.getMessage();
		}
		InsuranceDocument id = new InsuranceDocument();
		try {
			VehicleInsurance vi = vehicleService.searchVehicleInsuranceById(dto.getInsuranceId());
			id.setInsurance(vi.getInsurance());
			id.setCustomer(vi.getVehicle().getCustomer());
			id.setInsuranceDocumentPath(targetFile);
			InsuranceDocument id1 = insuranceService.addOrUpdateInsuranceDocument(id);
			if (id1 != null) {
				return "File uploaded";

			}
			return "Upload failed";

		} catch (Exception e) {
			return "Upload failed";
		}

	}
//	@PostMapping(value="/addvehicle")
//	public Vehicle registervehicle(@RequestBody Vehicle vehicle) {
//		Vehicle  message = vehicleService.ResgisterVehicle(vehicle);
//		return message;
//		
//	}

}
