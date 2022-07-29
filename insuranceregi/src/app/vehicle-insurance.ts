import { Vehicle } from "./vehicle";
import { VehicleInsurancePlan } from "./vehicle-insurance-plan";

export class VehicleInsurance {
    vehicleInsuranceId:number;
    issueDate:string;
    years:number;
    amountPaidV:number;
    vehicle:Vehicle;
    vehiclePlan:VehicleInsurancePlan;
}
