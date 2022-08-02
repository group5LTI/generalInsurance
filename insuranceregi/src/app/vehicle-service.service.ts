import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyVInsuranceDto } from './buy-vinsurance-dto';
import { Observable } from 'rxjs';
import { AddVehiclePlan } from './add-vehicle-plan';
import { VehicleInsurance } from './vehicle-insurance';
import { ViewAlldto } from './view-alldto';

@Injectable({
  providedIn: 'root'
})
export class VehicleServiceService {

  constructor(private httpClient:HttpClient) { }

  addVehicleInsurance(buyDto:BuyVInsuranceDto):Observable<VehicleInsurance>{
    return this.httpClient.post<VehicleInsurance>("http://localhost:9090/vehicles/buyvehicleinsurance",buyDto)
  }
  AddVehiclePlan(addVplan:AddVehiclePlan):Observable<string>
  {
    return this.httpClient.post("http://localhost:9090/vehicles/registervehicleplan",addVplan,{responseType:'text'})
  }
  getInsurances(userName:string):Observable<VehicleInsurance[]>
  {
    return this.httpClient.get<VehicleInsurance[]>("http://localhost:9090/vehicles/viewallinsurance?userName="+userName);
  }

  getVInsuranceId(userName:string):Observable<number[]>
  {
    return this.httpClient.get<number[]>("http://localhost:9090/vehicles/viewallinsuranceid?userName="+userName);
  }
}
