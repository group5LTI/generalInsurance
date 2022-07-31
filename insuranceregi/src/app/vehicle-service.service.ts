import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyVInsuranceDto } from './buy-vinsurance-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleServiceService {

  constructor(private httpClient:HttpClient) { }

  addVehicleInsurance(buyDto:BuyVInsuranceDto):Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:9090/vehicles/buyvehicleinsurance",buyDto)
  }
}
