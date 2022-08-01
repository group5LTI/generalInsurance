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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_vehicleinsurance")
public class VehicleInsurance {

@Id
@SequenceGenerator(name="vehicle_insu_seq",initialValue = 7000,allocationSize = 1)
@GeneratedValue(generator = "vehicle_insu_seq" ,strategy = GenerationType.SEQUENCE)

int vehicleInsuranceId;
String issueDate;
int years;
double amountPaidV;

@ManyToOne
@JoinColumn(name = "vehicle_plan_id")
VehicleInsurancePlan vehicleInsurancePlan;

@OneToOne
@JoinColumn(name = "vehicle_id")
Vehicle vehicle;

@OneToOne(mappedBy = "vehicleInsurance", cascade = CascadeType.ALL)
Insurance insurance;


public int getVehicleInsuranceId() {
	return vehicleInsuranceId;
}

public void setVehicleInsuranceId(int vehicleInsuranceId) {
	this.vehicleInsuranceId = vehicleInsuranceId;
}

public String getIssueDate() {
	return issueDate;
}

public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}

public int getYears() {
	return years;
}

public void setYears(int years) {
	this.years = years;
}

public double getAmountPaidV() {
	return amountPaidV;
}

public void setAmountPaidV(double amountPaidV) {
	this.amountPaidV = amountPaidV;
}

@JsonIgnore
public VehicleInsurancePlan getVehicleInsurancePlan() {
	return vehicleInsurancePlan;
}

public void setVehicleInsurancePlan(VehicleInsurancePlan vehicleInsurancePlan) {
	this.vehicleInsurancePlan = vehicleInsurancePlan;
}

@JsonIgnore
public Vehicle getVehicle() {
	return vehicle;
}

public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}

@JsonIgnore
public Insurance getInsurance() {
	return insurance;
}

public void setInsurance(Insurance insurance) {
	this.insurance = insurance;
}


}
