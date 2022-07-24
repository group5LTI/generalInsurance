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
public class TravelInsurancePlan {

	@Id
	@SequenceGenerator(name = "travel_plan_seq", initialValue = 40000, allocationSize = 1)
	@GeneratedValue(generator = "travel_plan_seq", strategy = GenerationType.SEQUENCE)
	int travelPlanId;
	int numOfPeople;
	String location;
	int duration;
	double plannedAmount;
	
	@OneToMany(mappedBy = "travelInsurancePlan",cascade = CascadeType.ALL)
	List<TravelInsurance> TravelInsurances;

	public int getTravelPlanId() {
		return travelPlanId;
	}

	public void setTravelPlanId(int travelPlanId) {
		this.travelPlanId = travelPlanId;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPlannedAmount() {
		return plannedAmount;
	}

	public void setPlannedAmount(double plannedAmount) {
		this.plannedAmount = plannedAmount;
	}

	public List<TravelInsurance> getTravelInsurances() {
		return TravelInsurances;
	}

	public void setTravelInsurances(List<TravelInsurance> travelInsurances) {
		TravelInsurances = travelInsurances;
	}
	
	
}
