import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-travel-page',
  templateUrl: './travel-page.component.html',
  styleUrls: ['./travel-page.component.css']
})
export class TravelPageComponent implements OnInit {
user:User = new User();
  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
  checkVUser(){
    if(this.user.userName=="Admin"){
      this.router.navigate(['/addVehiclePlan'])
    }
    else{
      this.router.navigate(['/buyLink']);
    }
  }
  checkTUser(){
    if(this.user.userName=="Admin"){
      this.router.navigate(['/addTravelPlan'])
    }
    else{
      this.router.navigate(['/travelpageLink']);
    }
  }

}
