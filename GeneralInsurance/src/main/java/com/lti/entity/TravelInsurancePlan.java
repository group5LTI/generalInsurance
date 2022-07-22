package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TravelInsurancePlan {

	@Id
	int travelPlanId;
	int numOfPeople;
	String location;
	int duration;
	double plannedAmount;
	
	@OneToMany(mappedBy = "travelInsurancePlan",cascade = CascadeType.ALL)
	List<TravelInsurance> TravelInsurances;
}
