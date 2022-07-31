import { Component, OnInit } from '@angular/core';
import { TravelServiceService } from '../travel-service.service';
import { Router } from '@angular/router';
import { BuyTinsuranceDto } from '../buy-tinsurance-dto';
import { Login } from '../login';
import { User } from '../user';
import { TravelInsurance } from '../travel-insurance';

@Component({
  selector: 'travel-insurance',
  templateUrl: './travel-insurance.component.html',
  styleUrls: ['./travel-insurance.component.css']
})
export class TravelComponent implements OnInit {

  buyTDto:BuyTinsuranceDto = new BuyTinsuranceDto();
  plan = ['Silver','Gold','Diamond']
  planHasError = true;
  login:Login = new Login();
  TravelInsurance:TravelInsurance = new TravelInsurance();
  isValid:boolean;
  msg:string;
  user:User = new User();

  // travelModel = new Travel('','','','default');
  constructor(private travelService:TravelServiceService,private router:Router) {}


  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("UserDetails"));
   }

  addTravelInsurance() {
    this.buyTDto.userId = this.user.userId;
    console.log(this.buyTDto); 
    console.log(this.login);
    console.log(this.user);
    // this.travelService.addTravelInsurance(this.buyTDto).subscribe(
    //   buytravelInsurance=> {
    //     this.isValid = buytravelInsurance;
    //     // console.log(this.isValid);
    //     if(this.isValid) {
    //       alert("Congratulations you have choosed " + this.buyTDto.planType+" for "+this.buyTDto.planDuration+" years/s");
    //       this.router.navigate(['paymentLink'])
    //     }
    //     else {
    //       alert("Right now "+this.buyTDto.planType+" plan is not available");
    //     }
    //   }
    // )
  }
  validatePlan(value:String) {
    if(value == 'default') {
      this.planHasError = true;
    }else {
      this.planHasError = false;
    }
  }
}
