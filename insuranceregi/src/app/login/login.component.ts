import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
login:Login=new Login();
message:string;
isValid:boolean;
validatedUser:User=new User();
  constructor(private registerService:RegisterService) { }

  ngOnInit(): void {
  }
checkLogin()
{
console.log(JSON.stringify(this.login));
this.registerService.loginUser(this.login)
.subscribe(
msg=>{
  this.isValid=msg;
  if(this.isValid)
  {
    this.message="Login Successful";
  }
  else{
    this.message="login failed";
  }
}

);




}
}
