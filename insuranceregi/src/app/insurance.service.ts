import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VehicleInsurance } from './vehicle-insurance';
import { RenewVehicleInsurance } from './renew-vehicle-insurance';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {

  constructor(private httpClient:HttpClient) { }

  
  renewinsurance(vinsurance:VehicleInsurance):Observable<RenewVehicleInsurance>{
    return this.httpClient.put<RenewVehicleInsurance>("http://localhost:9090/vehicles/renew",vinsurance);
  }
}
