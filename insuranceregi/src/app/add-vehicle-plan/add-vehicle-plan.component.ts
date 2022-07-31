import { Component, OnInit } from '@angular/core';
import { AddVehiclePlan } from '../add-vehicle-plan';
import { VehicleServiceService } from '../vehicle-service.service';

@Component({
  selector: 'app-add-vehicle-plan',
  templateUrl: './add-vehicle-plan.component.html',
  styleUrls: ['./add-vehicle-plan.component.css']
})
export class AddVehiclePlanComponent implements OnInit {
addVehicleplan:AddVehiclePlan=new AddVehiclePlan();
message:string;
  constructor(private vehicleService:VehicleServiceService) { }

  ngOnInit(): void {
  }
  AddVehiclePlan()
  {
    console.log(JSON.stringify(this.addVehicleplan));
    this.vehicleService.AddVehiclePlan(this.addVehicleplan)
    .subscribe(
      msg=>{
        this.message=msg;
        alert(this.message);
        
      }
    );
    
  }
}
