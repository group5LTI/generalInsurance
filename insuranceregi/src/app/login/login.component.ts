import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { RegisterService } from '../register.service';
import { User } from '../user';
import { Router } from '@angular/router';

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
      this.registerService.getUser(this.login.userName)
      .subscribe(
        user=>{
          this.validatedUser=user;
          sessionStorage.setItem("userDetails",JSON.stringify(this.validatedUser));
          console.log(JSON.stringify(this.validatedUser));
        }
      );
      // sessionStorage.setItem("userId",this.login.)
      alert("Login Successful"+" Redirectiong to home page");
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
forgetPassword() {
  // this.registerService.forgetPassword(this.user.mailId).subscribe(response => {alert("We have sent you an email for setting your new password!")});
  //   sessionStorage.setItem("isAuthenticated", "true");
  this.router.navigate(['forgotLink'])
  }
 



}

