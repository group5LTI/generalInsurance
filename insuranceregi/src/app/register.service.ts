import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient:HttpClient) { }

  registerUser(user:User):Observable<string>
  {
    return this.httpClient.post("http://localhost:9090/customers/register", user,{responseType:'text'});
  }

  loginUser(login:Login)
  {
    return this.httpClient.post<boolean>("http://localhost:9090/customers/login",login);
  }
}
