import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VehicleInsurance } from './vehicle-insurance';
import { Observable } from 'rxjs';
import { RenewRegisterVInsuranceDto } from './renew-register-vinsurance-dto';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {

  constructor(private httpClient:HttpClient) { }

  
  renewinsurance(vinsurance:RenewRegisterVInsuranceDto):Observable<string>{
    return this.httpClient.put("http://localhost:9090/vehicles/renew",vinsurance,{responseType:'text'});
  }
}
