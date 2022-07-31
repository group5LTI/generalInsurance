import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyVInsuranceDto } from './buy-vinsurance-dto';
import { Observable } from 'rxjs';
import { AddVehiclePlan } from './add-vehicle-plan';

@Injectable({
  providedIn: 'root'
})
export class VehicleServiceService {

  constructor(private httpClient:HttpClient) { }

  addVehicleInsurance(buyDto:BuyVInsuranceDto):Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:9090/vehicles/buyvehicleinsurance",buyDto)
  }
  AddVehiclePlan(addVplan:AddVehiclePlan):Observable<string>
  {
    return this.httpClient.post("http://localhost:9090/vehicles/registervehicleplan",addVplan,{responseType:'text'})
  }
}
