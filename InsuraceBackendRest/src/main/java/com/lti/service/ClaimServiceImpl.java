package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ClaimDao;
import com.lti.dao.ClaimDocumentDao;
import com.lti.dto.ClaimDto;
import com.lti.dto.ClaimViewDto;
import com.lti.dto.ViewUnverifiedDto;
import com.lti.entity.ClaimDocument;
import com.lti.entity.ClaimInsurance;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimDao claimDao;
	
	@Autowired
	ClaimDocumentDao claimDocumentDao;

	@Override
	public ClaimInsurance addclaimsignup(ClaimInsurance claim) {
		ClaimInsurance claim2;
		try {
			System.out.println(claim.getInsurance().getInsuranceId());
			claim2 = claimDao.AddOrUpdateClaim(claim);
			return claim2;
		} catch (Exception e) {
			System.out.println("Inside sevice");
			return null;
		}
	}
	@Override
	public ClaimInsurance findClaim(int claimId) {
		return claimDao.searchClaimById(claimId);
	}
	@Override
	public List<ClaimInsurance> viewAllClaim() {
		return claimDao.viewAllClaims();
	}
	@Override
	public ClaimDto updateClaimInsurance(ClaimInsurance claim) {
		ClaimDto dto = new ClaimDto();
		try {
			ClaimInsurance clm = claimDao.AddOrUpdateClaim(claim);
			dto.setMessage("Claim Updated");
			dto.setIns(clm);
			return dto;
		} catch (Exception e) {
			dto.setMessage(e.getMessage());
			return dto;
		}
	}
	@Override
	public ClaimDocument addOrUpdateClaimDocument(ClaimDocument cd) {
		// TODO Auto-generated method stub
		return claimDocumentDao.AddOrUpdateClaimDocument(cd);
	}
	@Override
	public ClaimDocument searchClaimDocumentByClaimId(int insIdUpload) {
		// TODO Auto-generated method stub
		return claimDocumentDao.searchClaimDoucmentByClaimId(insIdUpload);
	}
	@Override
	public ClaimDocument updateClaimInsuranceDocument(ClaimDocument idoc) {
		// TODO Auto-generated method stub
		return claimDocumentDao.AddOrUpdateClaimDocument(idoc);
	}
	@Override
	public List<ViewUnverifiedDto> viewAllUnverifiedClaim() {
		// TODO Auto-generated method stub
		return claimDao.viewAllUnverifiedClaims();
	}
	@Override
	public boolean checkStatus(int claimId,String status) {
		// TODO Auto-generated method stub
		return claimDao.checkStatus(claimId,status);
	}
	@Override
	public List<ClaimViewDto> viewClaimsUserName(int userIdd) {
		// TODO Auto-generated method stub
		return claimDao.viewClaimsUserName(userIdd);
	}
}
