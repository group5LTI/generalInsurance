import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Claim } from './Claim'
import { ViewAllClaims } from './view-all-claims';


@Injectable({
  providedIn: 'root'
})
export class ClaimService {

  constructor(private httpClient:HttpClient) { }

  claimDocument(claim: Claim)
  {
    return this.httpClient.post<boolean> ("http://localhost:9708/claims/signup", claim);
  }
  getAllClaims():Observable<ViewAllClaims[]>{
    return this.httpClient.get<ViewAllClaims[]>("http://localhost:9708/claims/viewAll");

  }
}
