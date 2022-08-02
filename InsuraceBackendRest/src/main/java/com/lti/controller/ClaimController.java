package com.lti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimDocumentDto;
import com.lti.dto.ClaimDto;
import com.lti.dto.ClaimInsuranceDto;
import com.lti.dto.ClaimViewDto;
import com.lti.dto.InsuranceDocumentDto;
import com.lti.dto.UpdateCustomer;
import com.lti.dto.ViewUnverifiedDto;
import com.lti.entity.ClaimDocument;
import com.lti.entity.ClaimInsurance;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.InsuranceDocument;
import com.lti.entity.TravelInsurance;
import com.lti.entity.VehicleInsurance;
import com.lti.exception.InsuranceNotFound;
import com.lti.exception.RegistrationError;
import com.lti.service.ClaimService;
import com.lti.service.CustomerService;
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
	
	@Autowired
	InsuranceService insuranceService;
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/addclaimsignup", method = RequestMethod.POST)
	public ClaimInsurance addclaimsignup(@RequestBody ClaimInsuranceDto claim) {
		ClaimInsurance c = new ClaimInsurance();
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
					ClaimInsurance claim1 = claimservice.addclaimsignup(c);
					ClaimDocument cd = new ClaimDocument();
					cd.setClaiminsurance(claim1);
					ClaimDocument cd1 = claimservice.addOrUpdateClaimDocument(cd);
					message=cd1!=null?"Success":"Failure";
					return claim1;
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
				if(t.getCustomer().getUserId()==claim.getUserId()) {
					ClaimInsurance claim1 = claimservice.addclaimsignup(c);
					ClaimDocument cd = new ClaimDocument();
					cd.setClaiminsurance(claim1);
					ClaimDocument cd1 = claimservice.addOrUpdateClaimDocument(cd);
					message=cd1!=null?"Success":"Failure";
					return claim1;
				}
			}
			else {
				throw new InsuranceNotFound("No insuarnce Found");
			}
		}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	//IDEA
	@PostMapping("/updateclaim")
    public ClaimDto updateClaimInsurance(@RequestBody ClaimInsurance claim)
    {
		ClaimInsurance c = claimservice.findClaim(claim.getClaimId());
		c.setClaimDate(LocalDate.now().toString());
		c.setInsurance(claim.getInsurance());
		c.setAccountNo(claim.getAccountNo());
		c.setClaimAmount(claim.getClaimAmount());
		c.setClaimId(claim.getClaimId());
		c.setReason(claim.getReason());
		c.setReason(c.getReason());
		c.setApproval(claim.getApproval());
		c.setApprovedAmount(claim.getApprovedAmount());
        return claimservice.updateClaimInsurance(c);
    }

	@GetMapping(value = "/{claimId}")
	public ClaimInsurance searchClaim(@PathVariable int claimId) {
		return claimservice.findClaim(claimId);
	}

	@GetMapping(value = "/viewallunverified")
	@ResponseBody
	public List<ViewUnverifiedDto> viewAllClaims(HttpServletRequest request) {
		List<ViewUnverifiedDto> lists = claimservice.viewAllUnverifiedClaim();
		for (ViewUnverifiedDto dto : lists) {
			downloadDocument(dto.getClaimId(), request);
		}
		return lists;
		
	}
	@PostMapping(value = "/upload-claimdocument")
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.ALL_VALUE ,value = "/upload-document")
	public String uploadDocument(@ModelAttribute ClaimDocumentDto dto, HttpServletRequest request) {
		int insIdUpload=dto.getClaimId();
		String imageUploadLocation = "c:/uploads/";
		String fileName = dto.getClaimInsuranceDocument().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(dto.getClaimInsuranceDocument().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			return e.getMessage();
		}
		System.out.println(insIdUpload);
//		InsuranceDocument idoc = insuranceService.searchInsuranceDocumentByInsuranceId(insIdUpload);
		ClaimDocument idoc = claimservice.searchClaimDocumentByClaimId(insIdUpload);
		System.out.println(idoc.getClaiminsurance().getInsurance().getInsuranceDocument().getCustomer().getUserId());
		try {
			if (idoc.getClaiminsurance().getInsurance().getInsuranceDocument().getCustomer().getUserId() == dto.getUserId()) {

				idoc.setClaimDocumentPath(fileName);
				ClaimDocument id1 = claimservice.updateClaimInsuranceDocument(idoc);
//				ClaimDocument id2
//				InsuranceDocument id1 = insuranceService.updateInsuranceDocument(idoc);
				if (id1 != null) {
					ClaimDocument id = downloadDocument(insIdUpload,request);
					if(id!=null) {
					System.out.println("Downloaded file you have uploaded");
					}
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
//	@GetMapping("/downloaddocument")
	public ClaimDocument downloadDocument(int id, HttpServletRequest request) {
		// fetching customer data from the database
		ClaimDocument idoc = claimservice.searchClaimDocumentByClaimId(id);
		//InsuranceDocument idoc = insuranceService.searchInsuranceDocumentByInsuranceId(id);
		// reading the project's deployed folder location
		String projPath = request.getServletContext().getRealPath("/");
		String tempDownloadPath = projPath + "/downloads/";
		System.out.println(tempDownloadPath);
		// creating a folder within the project where we will place the profile pic of
		// the customer getting fetched
		File f = new File(tempDownloadPath);
		if (!f.exists())
			f.mkdir();
		String targetFile = tempDownloadPath + idoc.getClaimDocumentPath();

		// the original location where the uploaded images are present
		String uploadedImagesPath = "c:/uploads/";
		String sourceFile = uploadedImagesPath + idoc.getClaimDocumentPath();

		try {
			FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			// maybe for this customer there is no profile pic
		}

		return idoc;
	}
	@RequestMapping(value="/verify/{claimId}/{status}",method = RequestMethod.GET)
	@ResponseBody
	public boolean checkStatus(@PathVariable int claimId ,@PathVariable String status) {
		
		return claimservice.checkStatus(claimId,status);
	} 
	@RequestMapping(value="/viewclaims/{userName}",method=RequestMethod.GET)
	@ResponseBody
	public List<ClaimViewDto> viewAllClaimInsurances(@PathVariable String userName) {
		Customer cust = customerService.searchUserByUsername(userName);
		int userIdd = cust.getUserId();
		return claimservice.viewClaimsUserName(userIdd);
		
	}
}
