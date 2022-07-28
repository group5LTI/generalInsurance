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
import javax.persistence.Table;

@Entity
@Table(name = "tbl_travelinsurance")
public class TravelInsurance {

	@Id
	@SequenceGenerator(name = "travelinsu_seq", initialValue = 5000, allocationSize = 1)
	@GeneratedValue(generator = "travelinsu_seq", strategy = GenerationType.SEQUENCE)
	int travelInsuranceId;

	String location;
	LocalDate travelStartDate;
	LocalDate travelEndDate;
	double amountPaid;

	@ManyToOne
	@JoinColumn(name = "travel_plan_id")
	TravelInsurancePlan travelInsurancePlan;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
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

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	
	public TravelInsurancePlan getTravelInsurancePlan() {
		return travelInsurancePlan;
	}

	public void setTravelInsurancePlan(TravelInsurancePlan travelInsurancePlan) {
		this.travelInsurancePlan = travelInsurancePlan;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	

}
