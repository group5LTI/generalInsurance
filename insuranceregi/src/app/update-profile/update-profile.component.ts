import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  constructor(private registerService:RegisterService,private router:Router) { }
  user:User=new User();
  updatemessage:string;
  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }

  updateProfile()
  {
    this.registerService.updateProfile(this.user)
    .subscribe(
      updateUser=>
      {
        this.user=updateUser.user;
        this.updatemessage=updateUser.message;
      }
    );
    alert("Update Successful"+" Redirectiong to home page");
    this.router.navigate(['dbLink'])
  }
}
