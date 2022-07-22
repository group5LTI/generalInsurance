package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class VehicleInsurance {

	@Id
	int vehicleInsuranceId;
	LocalDate issue_date;
	int years;
	double amountPaid;
	
	@ManyToOne
	@JoinColumn(name = "vehicleInsurancePlanId")
	VehicleInsurancePlan vehicleInsurancePlan;
	
	@OneToOne(mappedBy = "vehicleInsurance")
	Insurance insurance;

	public int getVehicleInsuranceId() {
		return vehicleInsuranceId;
	}

	public void setVehicleInsuranceId(int vehicleInsuranceId) {
		this.vehicleInsuranceId = vehicleInsuranceId;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public VehicleInsurancePlan getVehicleInsurancePlan() {
		return vehicleInsurancePlan;
	}

	public void setVehicleInsurancePlan(VehicleInsurancePlan vehicleInsurancePlan) {
		this.vehicleInsurancePlan = vehicleInsurancePlan;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
}
