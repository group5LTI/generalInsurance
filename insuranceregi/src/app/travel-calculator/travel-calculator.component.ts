import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CalTravelInput } from '../cal-travel-input';
import { CalTravel } from '../calTravel';
import { CalTravelDto } from '../calTravelDto';
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
  TravelInput: CalTravelInput = new CalTravelInput();
  name: String = "Hello"

  
  message: string;
  
  // CalTravel:calTravel=new calTravel();

  clickmsg = '';
  ngOnInit(): void {
    // this.calculate_travel = JSON.parse(sessionStorage.getItem(""))
  }

  test(){
    alert("hello")
  }

  calculate_travel(){
    console.log("//", this.TravelInput)
    let data = this.travelService.getCalTravel(this.TravelInput)
    console.log("received .. ", this.TravelInput)
    // this.message=data?.message;
    // this.caltravel=data?.plan;
    }
  }




// console.log("//", this.TravelInput)
// this.travelService.getCalTravel(this.TravelInput)
//   .subscribe(data => {
//     console.log(" L33 ", data);
    // if(data){
    //   this.message=data?.message;
    //   this.caltravel=data?.plan;
    // }
    
  // }
  // );