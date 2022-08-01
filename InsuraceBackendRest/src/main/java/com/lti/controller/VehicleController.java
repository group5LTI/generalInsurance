package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BuyRegisterVInsuranceDto;
import com.lti.dto.BuyVInsuranceDto;
import com.lti.dto.InsuranceDocumentDto;
import com.lti.dto.PremiumTravelCalculate;
import com.lti.dto.PremiumVehicleCalculate;
import com.lti.dto.RenewVInsuranceDto;
import com.lti.dto.RenewedVInsurance;
import com.lti.dto.ReturnMessageTravelPremium;
import com.lti.dto.ReturnMessageVehiclePremium;
import com.lti.dto.viewAllDto;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.InsuranceDocument;
import com.lti.entity.TravelInsurancePlan;
import com.lti.entity.Vehicle;
import com.lti.entity.VehicleInsurance;
import com.lti.entity.VehicleInsurancePlan;
import com.lti.exception.CheckIdException;
import com.lti.exception.InsuranceNotFound;
import com.lti.exception.InsurancePlanNotFound;
import com.lti.exception.RegistrationError;
import com.lti.exception.VehicleNotFound;
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
						Insurance i = new Insurance();
						i.setVehicleInsurance(b);
						Insurance insurance = vehicleService.addVehicleInsurance(i);
						VehicleInsurance vf = vehicleService.searchVehicleInsuranceById(b.getVehicleInsuranceId());
						vf.setInsurance(insurance);
						InsuranceDocument idoc = new InsuranceDocument();
						idoc.setCustomer(vehicle.getCustomer());
						idoc.setInsurance(insurance);
						InsuranceDocument idocument = insuranceService.addOrUpdateInsuranceDocument(idoc);
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
	public String renewVehicleInsurance(@RequestBody RenewVInsuranceDto vehicleInsurance) {
//		boolean renewed = vehicleService.renewVehicleInsurance(vehicleInsurance);
//		Vehicle vehicle = vehicleService.searchVehicleByVehicleId(vehicleInsurance.getVehicleId());
		VehicleInsurance v = vehicleService.searchVehicleInsuranceById(vehicleInsurance.getVehicleInsuranceId());
		try {
			if (v != null) {
				if (v.getVehicle().getCustomer().getUserId() == vehicleInsurance.getUserId()) {
					VehicleInsurancePlan vp = vehicleService.searchPlanByDurationType(v.getVehicle().getVehicleType(),
							vehicleInsurance.getPlanType(), vehicleInsurance.getPlanDuration());

					if (vp != null) {
						v.setVehicleInsurancePlan(vp);
						v.setAmountPaidV(vp.getPlannedAmountV());
						v.setYears(vp.getNoOfYears());
						v.setIssueDate(LocalDate.now().toString());
						VehicleInsurance vp1 = vehicleService.buyInsurance(v);
						if (vp1 != null) {

							// renew.setVi(vp1);
							return "Updated Successfully";
						} else {
							throw new RegistrationError("Error while renewing Insurance");
						}
					} else {
						throw new InsurancePlanNotFound("No plan available");
					}
				} else {
					throw new CheckIdException("No such Vehicle registered for your account");
				}
			} else {
				throw new VehicleNotFound("No such vehicle ID available!First buy insurance");
			}

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@PostMapping(value = "/registervehicleplan")
	public String registervehicleplan(@RequestBody VehicleInsurancePlan vehicleinsuranceplan) {

		String message = vehicleService.RegisterVehiclePlan(vehicleinsuranceplan);
		return message;
	}

	@PostMapping(value = "/upload-insurancedocument")
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.ALL_VALUE ,value = "/upload-document")
	public String uploadDocument(@ModelAttribute InsuranceDocumentDto dto) {

		String imageUploadLocation = "c:/uploads/";
		String fileName = dto.getInsuranceDocument().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(dto.getInsuranceDocument().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			return e.getMessage();
		}
		System.out.println(dto.getInsuranceId());
		InsuranceDocument idoc = insuranceService.searchInsuranceDocumentByInsuranceId(dto.getInsuranceId());
		System.out.println(idoc.getCustomer().getUserId());
		try {
			if (idoc.getCustomer().getUserId() == dto.getUserId()) {

				idoc.setInsuranceDocumentPath(fileName);
				InsuranceDocument id1 = insuranceService.updateInsuranceDocument(idoc);
				if (id1 != null) {
					return "File uploaded";

				} else {
					throw new RegistrationError("Document failed to upload");
				}
			} else {
				throw new InsuranceNotFound("No insurance found for this customer");
			}
			
			
		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	@GetMapping("/downloaddocument")
    public InsuranceDocument profile(@RequestParam("insuranceId") int id, HttpServletRequest request) {
        //fetching customer data from the database
        InsuranceDocument idoc = insuranceService.searchInsuranceDocumentByInsuranceId(id);
        //reading the project's deployed folder location
        String projPath = request.getServletContext().getRealPath("/");
        String tempDownloadPath = projPath + "/downloads/";
        //creating a folder within the project where we will place the profile pic of the customer getting fetched
        File f = new File(tempDownloadPath);
        if(!f.exists())
            f.mkdir();
        String targetFile = tempDownloadPath + idoc.getInsuranceDocumentPath();

        //the original location where the uploaded images are present
        String uploadedImagesPath = "c:/uploads/";
        String sourceFile = uploadedImagesPath + idoc.getInsuranceDocumentPath();

        try {
            FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            //maybe for this customer there is no profile pic
        }

        return idoc;
    }
	@GetMapping("/insurance/{insuranceId}")
	public InsuranceDocument searchCustomerByUsername(@PathVariable int insuranceId) {
		return insuranceService.searchInsuranceDocumentByInsuranceId(insuranceId);
	}
	
	@GetMapping(value="/calculatevehicle")
	public ReturnMessageVehiclePremium calculateTravelPremium(@RequestBody PremiumVehicleCalculate pvc) {
		
		VehicleInsurancePlan vp = vehicleService.searchPlanByDurationInsuranceType(pvc.getVehicleType(),
				pvc.getInsuranceType(), pvc.getNoOfYears());
		ReturnMessageVehiclePremium msg = new ReturnMessageVehiclePremium();
		if(vp!=null) {
			msg.setMessage("For your preferences we have found this plan");
			msg.setVip(vp);
			return msg;
		}
		else {
			msg.setMessage("No plan Available!");
			msg.setVip(null);
			return msg;
	
		}
	}

	
	@GetMapping("/viewAll")
	public List<VehicleInsurance> viewAllVehicleInsurances()
	{
		return vehicleService.viewAllVehicleInsurances();
	}
	@GetMapping("/viewallinsurance")
	public List<VehicleInsurance> viewAllVehicleInsurancesByuserId(@RequestParam("userName") String uname) {
		return vehicleService.viewAllVehicleInsurancesByUserName(uname);
	}
}
