import { Component, OnInit } from '@angular/core';
import { TravelInsurance } from '../travel-insurance';
import { TravelServiceService } from '../travel-service.service';
import { User } from '../user';
import { Vehicle } from '../vehicle';
import { VehicleInsurance } from '../vehicle-insurance';
import { VehicleServiceService } from '../vehicle-service.service';
import { ViewAlldto } from '../view-alldto';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {
  
  user:User=new User();
  userName:string;
  insurances:VehicleInsurance[]=[];
  tInsurances:TravelInsurance[]=[];
  vehicles:Vehicle=new Vehicle();
  constructor(private vehicleService:VehicleServiceService,private travelService:TravelServiceService) { }

  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
getInsurances()
{
  this.vehicleService.getInsurances(this.user.userName)
  .subscribe(
    obj=>{
      console.log(obj);
      this.insurances=obj;
    }
  );
}

getTInsurances()
{
  this.travelService.getTInsurances(this.user.userName)
  .subscribe(
    obj=>{
      console.log(obj);
      this.tInsurances=obj;
    }
  );
}
}
