import { Travel } from "./travel";
import { TravelInsurancePlan } from "./travel-insurance-plan";

export class TravelInsurance {
    travelInsuranceId:number;
	location:string;
	travelStartDate:string;
	travelEndDate:string;
	amountPaid:number;
    travelPlan:TravelInsurancePlan;
}
