import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClaimInsurance } from './claim-insurance';
import { ClaimInsuranceDto } from './claim-insurance-dto';

@Injectable({
  providedIn: 'root'
})
export class ClaimServiceService {

  constructor(private httpClient:HttpClient) { }

  addClaimInsurance(dto:ClaimInsuranceDto):Observable<string>{
    return this.httpClient.post("http://localhost:9090/claims/addclaimsignup",dto,{responseType:'text'});
  }
}
