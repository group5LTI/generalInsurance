
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { CalVehicleInput } from '../cal-vehicle-input';
import { CalVehicle } from '../calVehicle';
import { VehicleServiceService } from '../vehicle-service.service';

@Component({
  selector: 'app-vehicle-calculator',
  templateUrl: './vehicle-calculator.component.html',
  styleUrls: ['./vehicle-calculator.component.css']
})
export class VehicleCalculatorComponent implements OnInit {

  calvehicle:CalVehicle=new CalVehicle();
  VehicleInput: CalVehicleInput = new CalVehicleInput();
constructor(
  private vehicleService:VehicleServiceService,private router:Router
  ){}    

  data:any;
  message:string;
  ngOnInit() {}


calculate_Vehicle(){
  console.log("//", this.VehicleInput)
  this.vehicleService.getCalVehicle(this.VehicleInput)
  .subscribe(data=>{
    
    this.data=data;
    console.log(data);
  })
  // console.log("received .. ", this.TravelInput)
  // this.message=data?.message;
  // this.caltravel=data?.plan;
  }
}
