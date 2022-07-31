package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_travel_plan")
public class TravelInsurancePlan {

	@Id
	@SequenceGenerator(name = "travel_plan_seq", initialValue = 6000, allocationSize = 1)
	@GeneratedValue(generator = "travel_plan_seq", strategy = GenerationType.SEQUENCE)
	int travelPlanId;
	
	int noOfPeople;
	String travelLocation;
	int travleDuration;
	double plannedAmount;
	String planType; 

	@OneToMany(mappedBy = "travelInsurancePlan")
	List<TravelInsurance> travelInsurances;


	public int getTravelPlanId() {
		return travelPlanId;
	}

	public void setTravelPlanId(int travelPlanId) {
		this.travelPlanId = travelPlanId;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getTravelLocation() {
		return travelLocation;
	}

	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
	}




	public int getTravleDuration() {
		return travleDuration;
	}

	public void setTravleDuration(int travleDuration) {
		this.travleDuration = travleDuration;
	}

	public double getPlannedAmount() {
		return plannedAmount;
	}

	public void setPlannedAmount(double plannedAmount) {
		this.plannedAmount = plannedAmount;
	}

	public List<TravelInsurance> getTravelInsurances() {
		return travelInsurances;
	}

	public void setTravelInsurances(List<TravelInsurance> travelInsurances) {
		this.travelInsurances = travelInsurances;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	

}
