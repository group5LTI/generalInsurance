import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addtravelplan } from './addtravelplan';

@Injectable({
  providedIn: 'root'
})
export class TravelServiceService {

  constructor(private httpClient:HttpClient) { }
  AddTravelPlan(addTPlan:Addtravelplan):Observable<string>
  {
    return this.httpClient.post("http://localhost:9090/vehicles/registervehicleplan",addTPlan,{responseType:'text'})
  }

}
