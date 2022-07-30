import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../login';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {
  login:Login=new Login();
  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit(): void {
  }

  updatePassword(){
      // sessionStorage.setItem("isAuthenticated","false");
    // if(sessionStorage.getItem("isAuthenticated")=="true")
    // {
      this.registerService.updatePassword(this.login).subscribe(response=>{
        alert(JSON.stringify(response.message));
        this.router.navigate(['']);
      });
    // }
    // else{
      // alert("You are not authenticated to update your password!\nPlease make sure you came here through the link that we sent you.");
  }
}
