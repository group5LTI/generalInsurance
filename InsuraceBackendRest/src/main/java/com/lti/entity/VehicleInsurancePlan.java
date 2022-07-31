package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_vehicle_plan")
public class VehicleInsurancePlan {
	
	@Id
	@SequenceGenerator(name="vehicle_plan_seq" ,initialValue = 8000,allocationSize = 1)
	@GeneratedValue(generator = "vehicle_plan_seq",strategy = GenerationType.SEQUENCE)
	int vehiclePlanId;
	
	double plannedAmountV;
	String vehicleType;
	int noOfYears;
	String insuranceType;
	String planType;
	
	@OneToMany(mappedBy = "vehicleInsurancePlan")
	List<VehicleInsurance> vehicleInsurances;

	public int getVehiclePlanId() {
		return vehiclePlanId;
	}

	public void setVehiclePlanId(int vehiclePlanId) {
		this.vehiclePlanId = vehiclePlanId;
	}

	public double getPlannedAmountV() {
		return plannedAmountV;
	}

	
	public void setPlannedAmountV(double plannedAmountV) {
		this.plannedAmountV = plannedAmountV;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	
	public List<VehicleInsurance> getVehicleInsurances() {
		return vehicleInsurances;
	}

	public void setVehicleInsurances(List<VehicleInsurance> vehicleInsurances) {
		this.vehicleInsurances = vehicleInsurances;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	
}
