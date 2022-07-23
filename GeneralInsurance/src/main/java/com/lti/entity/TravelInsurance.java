package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TravelInsurance {

	@Id
	@SequenceGenerator(name = "travel_insurance_seq", initialValue = 30000, allocationSize = 1)
	@GeneratedValue(generator = "travel_insurance_seq", strategy = GenerationType.SEQUENCE)
	int travelInsuranceId;
	String location;
	LocalDate travelStartDate;
	LocalDate travelEndDate;
	double amountpaid;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "travelPlanId")
	TravelInsurancePlan travelInsurancePlan;
	
	@OneToOne(mappedBy = "travelInsurance")
	Insurance insurance;

	public int getTravelInsuranceId() {
		return travelInsuranceId;
	}

	public void setTravelInsuranceId(int travelInsuranceId) {
		this.travelInsuranceId = travelInsuranceId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(LocalDate travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	public LocalDate getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(LocalDate travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	public double getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(double amountpaid) {
		this.amountpaid = amountpaid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public TravelInsurancePlan getTravelInsurancePlan() {
		return travelInsurancePlan;
	}

	public void setTravelInsurancePlan(TravelInsurancePlan travelInsurancePlan) {
		this.travelInsurancePlan = travelInsurancePlan;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
}
