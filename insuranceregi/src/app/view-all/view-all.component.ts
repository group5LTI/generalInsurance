import { Component, OnInit } from '@angular/core';
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

  insurances:VehicleInsurance[]=[];
  vehicles:Vehicle=new Vehicle();
  constructor(private vehicleService:VehicleServiceService) { }

  ngOnInit(): void {
  }
getInsurances()
{
  this.vehicleService.getInsurances()
  .subscribe(
    obj=>{
      console.log(obj);
      this.insurances=obj;
    }
  );
}
}
