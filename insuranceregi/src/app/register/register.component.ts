import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user:User=new User();
isValid:boolean;
  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit(): void {
  }
register()
{
console.log(JSON.stringify(this.user));
this.registerService.registerUser(this.user)
    .subscribe(
      msg=>{
        this.isValid=msg;
        if(this.isValid){
        alert("Registartion Successful"+" Redirecting to login page");
        console.log(JSON.stringify(this.isValid));
        this.router.navigate(['loginLink'])
        }
        else{
          alert("UserName already exists! try other userName");
        }
      }
    );
}
}

// registerUser() {
//   console.log(JSON.stringify(this.userRegistration));      ///////////////////////////////////////////////////////////////
//   this.userService.register(this.userRegistration).subscribe(response => {
//     // this.message=response;                             ////////////////////////////////////////////////////////////////////
//     //   console.log(JSON.stringify(this.message));
//     Swal.fire(
//       response.status,
//       response.message
//     )
// if(response.status=="SUCCESS"){
//       this.router.navigate(['user_login'])
//     }
//   })
// }