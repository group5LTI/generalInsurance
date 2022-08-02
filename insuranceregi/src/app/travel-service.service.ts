import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addtravelplan } from './addtravelplan';
import { BuyTinsuranceDto } from './buy-tinsurance-dto';
import { ReturnInsuranceMessage } from './return-insurance-message';
import { TravelInsurance } from './travel-insurance';

@Injectable({
  providedIn: 'root'
})
export class TravelServiceService {

  constructor(private httpClient:HttpClient) { }
  AddTravelPlan(addTPlan:Addtravelplan):Observable<string>
  {
    return this.httpClient.post("http://localhost:9090/travel/registertravelplan",addTPlan,{responseType:'text'})
  }

  addTravelInsurance(buyTDto:BuyTinsuranceDto):Observable<TravelInsurance>{
    return this.httpClient.post<TravelInsurance>("http://localhost:9090/travel/buytravelinsurance",buyTDto)
  }

 getTInsurances(userName:string):Observable<TravelInsurance[]>
  {
    return this.httpClient.get<TravelInsurance[]>("http://localhost:9090/travel/viewallTinsurance?userName="+userName);
  }
}
