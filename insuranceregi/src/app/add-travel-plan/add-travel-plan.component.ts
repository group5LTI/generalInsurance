import { Component, OnInit } from '@angular/core';
import { Addtravelplan } from '../addtravelplan';
import { TravelServiceService } from '../travel-service.service';

@Component({
  selector: 'app-add-travel-plan',
  templateUrl: './add-travel-plan.component.html',
  styleUrls: ['./add-travel-plan.component.css']
})
export class AddTravelPlanComponent implements OnInit {
  addtravelPlan:Addtravelplan=new Addtravelplan();
  message:string;
  constructor(private planService:TravelServiceService) { }

  ngOnInit(): void {
  }

  AddTravelPlan()
  {
    console.log(JSON.stringify(this.addtravelPlan));
    this.planService.AddTravelPlan(this.addtravelPlan)
    .subscribe(
      msg=>{
        this.message=msg;
        alert(this.message);
        
      }
    );
  }
}
