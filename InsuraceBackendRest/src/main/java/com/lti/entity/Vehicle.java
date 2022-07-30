package com.lti.entity;

import javax.persistence.CascadeType;
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
@Table(name = "tbl_vehicle")
public class Vehicle {
	
	@Id
	@SequenceGenerator(name="vehicle_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "vehicle_seq",strategy = GenerationType.SEQUENCE)
	int vehicleId;
	String brand;
	String vehicleType;
	String chassisNumber;
	String drivingLicence;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@OneToOne(mappedBy = "vehicle" ,cascade = CascadeType.ALL)
	VehicleInsurance vehicleInsurance;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}
	
	

}
