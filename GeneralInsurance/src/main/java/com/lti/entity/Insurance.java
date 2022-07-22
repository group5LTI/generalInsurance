package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Insurance {

	@Id
	int insuranceId;
	
	@OneToMany(mappedBy = "insurance",cascade = CascadeType.ALL)
	List<Claim> claims;
	
	@OneToOne
	@JoinColumn(name="vehicleInsuranceId")
	VehicleInsurance vehicleInsurance;
	
	@OneToOne
	@JoinColumn(name="travelInsuranceId")
	TravelInsurance travelInsurance;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	public TravelInsurance getTravelInsurance() {
		return travelInsurance;
	}

	public void setTravelInsurance(TravelInsurance travelInsurance) {
		this.travelInsurance = travelInsurance;
	}
	
	
}
