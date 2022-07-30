import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
user:User=new User();
message:string;
isValid:boolean;
validatedUser:User=new User();
  constructor(private registerService:RegisterService,private router:Router) { }

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
    // this.message="Login Successful";
    alert("Login Successful"+" Redirectiong to home page");
    // sessionStorage.setItem("userId",this.login.)
    this.router.navigate(['dbLink'])
  }
  else{
    // this.message="login failed";
    alert("Login failed"+"\nEither username or password incorrect");
    // this.router.navigate(['registerLink'])
  }
}

);
}

}
