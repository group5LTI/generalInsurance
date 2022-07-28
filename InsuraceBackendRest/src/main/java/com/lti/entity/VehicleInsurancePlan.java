package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_vehicle_plan")
public class VehicleInsurancePlan {
	
	@Id
	@SequenceGenerator(name="vehicle_plan_seq" ,initialValue = 8000,allocationSize = 1)
	@GeneratedValue(generator = "vehicle_plan_seq",strategy = GenerationType.SEQUENCE)
	int vehiclePlanId;
	
	double plannedAmountV;
	VehicleType vehicleType;
	int noOfYears;
	InsuranceType insuranceType;
	
	@OneToMany(mappedBy = "vehicleInsurancePlan")
	List<VehicleInsurance> vehicleInsurances;

	public int getVehiclePlanId() {
		return vehiclePlanId;
	}

	public void setVehiclePlanId(int vehiclePlanId) {
		this.vehiclePlanId = vehiclePlanId;
	}

	public double getPlannedAmountV() {
		return plannedAmountV;
	}

	public void setPlannedAmountV(double plannedAmountV) {
		this.plannedAmountV = plannedAmountV;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public List<VehicleInsurance> getVehicleInsurances() {
		return vehicleInsurances;
	}

	public void setVehicleInsurances(List<VehicleInsurance> vehicleInsurances) {
		this.vehicleInsurances = vehicleInsurances;
	}

	
}
