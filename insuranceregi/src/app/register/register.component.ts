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
form1:FormGroup;
message:string;
  
  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit() : void{

   
  }
register()
{
console.log(JSON.stringify(this.user));
this.registerService.registerUser(this.user)
    .subscribe(
      msg=>{
        this.message=msg;
        console.log(JSON.stringify(this.message));
        this.router.navigate(['loginLink'])
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
//     if(response.status=="SUCCESS"){
//       this.router.navigate(['user_login'])
//     }
//   })
// }
