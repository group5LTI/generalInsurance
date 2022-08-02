package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.lti.dto.ClaimViewDto;
import com.lti.dto.ViewUnverifiedDto;
import com.lti.entity.ClaimDocument;
import com.lti.entity.ClaimInsurance;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;

@Component
public class ClaimDaoImpl implements ClaimDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public ClaimInsurance AddOrUpdateClaim(ClaimInsurance claim) {
		ClaimInsurance claimPersisted = null;
		try {
			claimPersisted = em.merge(claim);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return claimPersisted;
	}

	public ClaimInsurance searchClaimById(int claimId) {
		// TODO Auto-generated method stub
		return em.find(ClaimInsurance.class, claimId);
	}

	public List<ClaimInsurance> viewAllClaims() {
		// TODO Auto-generated method stub
		String jpql = "select cla from ClaimInsurance cla";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<ViewUnverifiedDto> viewAllUnverifiedClaims() {
//		String jpql = "select cla from ClaimInsurance cla where cla.approval=:uid";

		String jpql = "select cla , cd  from ClaimInsurance cla join ClaimDocument cd on cla.claimId=cd.claiminsurance.claimId where cla.approval='Pending'";
		// TypedQuery<ClaimInsurance> qry = em.createQuery(jpql, ClaimInsurance.class);
		TypedQuery<Object[]> qry = em.createQuery(jpql, Object[].class);
//        qry.setParameter("uid", "Pending");
		List<Object[]> allObjects = qry.getResultList();
		List<ViewUnverifiedDto> listDto = new ArrayList<>();
		ViewUnverifiedDto dto = null;
		for (Object[] obj : allObjects) {
			ClaimInsurance claimins = (ClaimInsurance) obj[0];
			ClaimDocument claimDoc = (ClaimDocument) obj[1];
			dto = new ViewUnverifiedDto();
			dto.setClaimId(claimins.getClaimId());
			dto.setClaimDate(claimins.getClaimDate());
			dto.setReason(claimins.getReason());
			dto.setApproval(claimins.getApproval());
			dto.setClaimAmount(claimins.getClaimAmount());
			dto.setClaimDocumentPath(claimDoc.getClaimDocumentPath());
			listDto.add(dto);
//		System.out.println(dto.getApproval());
		}
		return listDto;
	}

	@Transactional
	@Modifying
	public boolean checkStatus(int claimId, String status) {
		String jpql = "update ClaimInsurance set approval=:s where claimId=:id";
		Query qry = em.createQuery(jpql);
		qry.setParameter("s", status);
		qry.setParameter("id", claimId);
		if (qry.executeUpdate() == 1) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public List<ClaimViewDto> viewClaimsUserName(int userIdd) {
		// TODO Auto-generated method stub
		String jpql = "select cla , i from ClaimInsurance cla join Insurance i on cla.insurance.insuranceId=i.insuranceId where i.customer.userId=:uid";
		TypedQuery<Object[]> qry = em.createQuery(jpql, Object[].class);
		qry.setParameter("uid", userIdd);
		List<Object[]> allObjects = qry.getResultList();
		List<ClaimViewDto> listDto = new ArrayList<>();
		ClaimViewDto dto = null;
		for (Object[] obj : allObjects) {
			ClaimInsurance claimins = (ClaimInsurance) obj[0];
			Insurance ins = (Insurance) obj[1];
			dto = new ClaimViewDto();
			dto.setClaimId(claimins.getClaimId());
			dto.setAccountNo(claimins.getAccountNo());
			dto.setApproval(claimins.getApproval());
			System.out.println(claimins.getApproval());
			if(claimins.getApproval().equals("Approved")) {
			dto.setApprovedAmount(claimins.getClaimAmount()*0.8);
			}
			else {
				dto.setApprovedAmount(0);
			}
			dto.setClaimAmount(claimins.getClaimAmount());
			dto.setReason(claimins.getReason());
			dto.setUserId(ins.getCustomer().getUserId());
			listDto.add(dto);
		}
		return listDto;
	}

}
