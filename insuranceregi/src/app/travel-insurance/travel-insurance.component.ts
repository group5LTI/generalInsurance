import { Component, OnInit } from '@angular/core';
import { TravelServiceService } from '../travel-service.service';
import { Router } from '@angular/router';
import { BuyTinsuranceDto } from '../buy-tinsurance-dto';
import { Login } from '../login';
import { User } from '../user';
import { TravelInsurance } from '../travel-insurance';
import { RegisterService } from '../register.service';

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
  constructor(private travelService:TravelServiceService,private router:Router,private registerService:RegisterService) {}


  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("userDetails"));
   }

  addTravelInsurance() {
    console.log(this.user.userId);
    console.log(this.buyTDto)
    this.buyTDto.userId = this.user.userId;
    this.travelService.addTravelInsurance(this.buyTDto).subscribe(
      buytravelInsurance => {
        console.log(" >> L40", buytravelInsurance);
        this.isValid = buytravelInsurance.valid;
        // this.msg=buytravelInsurance.message;
        // console.log(this.isValid);
        if(this.isValid) {
          alert(this.msg);
          this.router.navigate(['paymentLink'])
        }
        else {
          alert(this.msg);
        }
      }
    )
  }
  validatePlan(value:String) {
    if(value == 'default') {
      this.planHasError = true;
    }else {
      this.planHasError = false;
    }
  }
}
