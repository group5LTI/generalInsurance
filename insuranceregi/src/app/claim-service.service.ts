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

  addClaimInsurance(dto:ClaimInsuranceDto):Observable<ClaimInsurance>{
    return this.httpClient.post<ClaimInsurance>("http://localhost:9090/claims/addclaimsignup",dto);
  }
  viewAllUnverifiedClaims():Observable<any>{
    return this.httpClient.get<any>("http://localhost:9090/claims/viewallunverified")
  }
  approveOrReject(id:number,status:string):Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:9090/claims/verify/"+id+"/"+status);
  }
  getCustomerClaims(name:string):Observable<any>{
    return this.httpClient.get<any>("http://localhost:9090/claims/viewclaims/"+name);
  }
}
