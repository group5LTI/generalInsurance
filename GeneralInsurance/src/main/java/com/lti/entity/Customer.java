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
public class Customer {
	
	@Id
	@SequenceGenerator(name = "customer_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
	int userId;
	
	String userName;
	String password;
	String mailId;
	String location;

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<Vehicle> vehicles;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<TravelInsurance> travelInsurances;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<InsuranceDocument> documents;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<TravelInsurance> getTravelInsurances() {
		return travelInsurances;
	}

	public void setTravelInsurances(List<TravelInsurance> travelInsurances) {
		this.travelInsurances = travelInsurances;
	}

	public List<InsuranceDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<InsuranceDocument> documents) {
		this.documents = documents;
	}
	
	
	
}
