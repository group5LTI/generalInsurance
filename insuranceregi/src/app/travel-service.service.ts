import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BuyTinsuranceDto } from './buy-tinsurance-dto';
import { ReturnInsuranceMessage } from './return-insurance-message';

@Injectable({
  providedIn: 'root'
})
export class TravelServiceService {

  constructor(private httpClient:HttpClient) { }
  addTravelInsurance(buyTDto:BuyTinsuranceDto):Observable<ReturnInsuranceMessage>{
    return this.httpClient.post<ReturnInsuranceMessage>("http://localhost:9090/travel/buytravelinsurance",buyTDto)
  }
}
