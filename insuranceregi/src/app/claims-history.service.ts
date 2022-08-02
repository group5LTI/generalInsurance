import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClaimsHistoryService {

  constructor(private http:HttpClient) { }

  public Signup(signup){
  return this.http.post("http://localhost:9708/claims/signup",{responseType:'text' as 'json'})
}
public  SearchClaimById(Id){
  return this.http.get("http://localhost:9708/claims/"+Id);
}


  public ListAllClaims(){
    return this.http.get("http://localhost:9708/claims/viewAll");
  }
  

}
