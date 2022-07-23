package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class VehicleInsurancePlan {

	@Id
	@SequenceGenerator(name = "vehicle_insurance_plan_seq", initialValue = 70000, allocationSize = 1)
	@GeneratedValue(generator = "vehicle_insurance_plan_seq", strategy = GenerationType.SEQUENCE)
	int vehicleInsurancePlanId;
	double amount;
	VehicleType vehicleType;
	int years;
	String insuranceType;
	
	@OneToMany(mappedBy = "vehicleInsurancePlan",cascade = CascadeType.ALL)
	List<VehicleInsurance> VehicleInsurances;
	
	
}
