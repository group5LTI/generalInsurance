import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
// import { ActivatedRoute, Router } from '@angular/router';
import { VehicleInsurancePlan } from '../vehicle-insurance-plan';
import { VehicleServiceService } from '../vehicle-service.service';

@Component({
  selector: 'app-vehicle-calculator',
  templateUrl: './vehicle-calculator.component.html',
  styleUrls: ['./vehicle-calculator.component.css']
})
export class VehicleCalculatorComponent implements OnInit {

  planDto:VehicleInsurancePlan = new VehicleInsurancePlan();
  message:string;
isValid:boolean;
validatedUser:VehicleInsurancePlan=new VehicleInsurancePlan();
  // planId:8040;
data:any;
  msg: VehicleInsurancePlan;
constructor(
  private vehicleService:VehicleServiceService,private router:Router
  ){}    

vehiclePlan:VehicleInsurancePlan=new VehicleInsurancePlan();
  ngOnInit() {
    // console.log(this.router.snapshot.params['vehiclePlanId'])
    console.log(JSON.stringify(this.planDto));
    this.getvehiclePlan();
    
}

// getvehiclePlan(){
//   // this.planDto.vehiclePlanId=8020;
// this.vehicleService.getvehiclePlan(this.planDto.vehiclePlanId)
// .subscribe(data=>
//   {
//     // console.log(data);
//     this.data=data;
//     console.log(this.data)
//   })
// }

// title='calTravel';
// getData(data:NgForm){
//   console.warn((data));
  
// }
// }
// planType = ['Silver','Gold','Diamond']

getvehiclePlan()
{
console.log(JSON.stringify(this.vehiclePlan));
this.vehicleService.getvehiclePlan(this.planDto.vehiclePlanId)
.subscribe(
msg=>{
  
  if(this.isValid)
  {
    // this.message="Login Successful";
    alert("Login Successful"+" Redirectiong to home page");
    // sessionStorage.setItem("userId",this.login.)
    // this.router.navigate(['dbLink'])
    this.msg=msg;
//     console.log(this.data)
  }
  else{
    // this.message="login failed";
    alert("Login failed"+"\nEither username or password incorrect");
    // this.router.navigate(['registerLink'])
  }
}

);
}

title='VehicleInsurancePlan';
getData(data:NgForm){
  console.warn((data));
  
}

}