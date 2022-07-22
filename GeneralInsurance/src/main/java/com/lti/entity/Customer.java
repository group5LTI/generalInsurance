package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	int userId;
	String userName;
	String password;
	String mailId;
	String location;

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<Vehicle> vehicles;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<TravelInsurance> travelInsurances;

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
	
	
	
}
