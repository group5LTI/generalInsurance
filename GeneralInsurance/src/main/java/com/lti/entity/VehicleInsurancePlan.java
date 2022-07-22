package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VehicleInsurancePlan {

	@Id
	int vehicleInsurancePlanId;
	double amount;
	VehicleType vehicleType;
	int years;
	String insuranceType;
	
	@OneToMany(mappedBy = "vehicleInsurancePlan",cascade = CascadeType.ALL)
	List<VehicleInsurance> VehicleInsurances;
	
	
}
