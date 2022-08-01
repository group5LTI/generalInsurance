import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyVInsuranceDto } from './buy-vinsurance-dto';
import { Observable, ObservableInput } from 'rxjs';
import { VehicleInsurancePlan } from './vehicle-insurance-plan';
import { AdminVerifyClaimComponent } from './admin-verify-claim/admin-verify-claim.component';

@Injectable({
  providedIn: 'root'
})
export class VehicleServiceService {


  constructor(private httpClient:HttpClient) { }

  addVehicleInsurance(buyDto:BuyVInsuranceDto):Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:9090/vehicles/buyvehicleinsurance",buyDto)
  }

  getvehiclePlan(planId:number):Observable<VehicleInsurancePlan>{

    return this.httpClient.get<VehicleInsurancePlan>("http://localhost:9090/vehicles/calTravel?planId="+planId);
    // return this.httpClient.get<User>("http://localhost:9191/customers/customer?userName="+userName);
    // return this.httpClient.get<VehicleInsurancePlan>("http://localhost:9191/vehicles/calTravel/"+vehiclePlanId);  users[0].name=Alice&users[0].age=26&users[1].name=Bob&users[1].age=16
  }



}
