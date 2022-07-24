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

	public int getVehicleInsurancePlanId() {
		return vehicleInsurancePlanId;
	}

	public void setVehicleInsurancePlanId(int vehicleInsurancePlanId) {
		this.vehicleInsurancePlanId = vehicleInsurancePlanId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public List<VehicleInsurance> getVehicleInsurances() {
		return VehicleInsurances;
	}

	public void setVehicleInsurances(List<VehicleInsurance> vehicleInsurances) {
		VehicleInsurances = vehicleInsurances;
	}
	
	
}
