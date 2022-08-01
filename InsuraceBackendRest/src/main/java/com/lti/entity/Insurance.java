package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tbl_insurance")
@JsonInclude(Include.NON_NULL)
public class Insurance {

	@Id
	@SequenceGenerator(name="insurance_seq",initialValue = 11000,allocationSize = 1)
	@GeneratedValue(generator = "insurance_seq",strategy = GenerationType.SEQUENCE)
	int insuranceId;
	
	@OneToOne
	@JoinColumn(name = "travelInsuranceId")
	TravelInsurance travelInsurance;
	
	@OneToOne
	@JoinColumn(name = "vehcileInsuranceId")
	VehicleInsurance vehicleInsurance;
	
	
	@OneToMany(mappedBy = "insurance")
	List<Claim> claims;
	
	@OneToOne(mappedBy = "insurance")
	InsuranceDocument insuranceDocument;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public TravelInsurance getTravelInsurance() {
		return travelInsurance;
	}

	public void setTravelInsurance(TravelInsurance travelInsurance) {
		this.travelInsurance = travelInsurance;
	}

	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	@JsonIgnore
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public InsuranceDocument getInsuranceDocument() {
		return insuranceDocument;
	}

	public void setInsuranceDocument(InsuranceDocument insuranceDocument) {
		this.insuranceDocument = insuranceDocument;
	}
	
	
	
}
