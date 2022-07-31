import { Component, OnInit } from '@angular/core';
import { calTravel } from '../calTravel';

@Component({
  selector: 'app-travel-calculator',
  templateUrl: './travel-calculator.component.html',
  styleUrls: ['./travel-calculator.component.css']
})
export class TravelCalculatorComponent implements OnInit {

  constructor() { }
caltravel:calTravel=new calTravel();
message:string;
clickmsg='';
  ngOnInit(): void {
  }

  calcTravel(){
    console.log(JSON.stringify(this.caltravel));
    this.clickmsg = 'You are my hero!';
  }
}
