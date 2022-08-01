import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CalTravelInput } from '../cal-travel-input';
import { CalTravel } from '../calTravel';
import { TravelServiceService } from '../travel-service.service';

@Component({
  selector: 'app-travel-calculator',
  templateUrl: './travel-calculator.component.html',
  styleUrls: ['./travel-calculator.component.css']
})
export class TravelCalculatorComponent implements OnInit {

  constructor(private travelService: TravelServiceService, private router: Router) { }
  // calctravel: CalTravel = new CalTravel();
  caltravel:CalTravel=new CalTravel();
  TravelInput:CalTravelInput=new CalTravelInput();

  
  message: string;
  
  // CalTravel:calTravel=new calTravel();

  clickmsg = '';
  ngOnInit(): void {
    this.calcTravel = JSON.parse(sessionStorage.getItem(""));
  }

  calcTravel() {
    this.travelService.getCalTravel(this.TravelInput)
      .subscribe(data => {
        // console.log(data);

        // this.message=data.message;
        // this.caltravel=data.plan;
      });



  }
}
