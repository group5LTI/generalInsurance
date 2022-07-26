import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'travel-insurance',
  templateUrl: './travel-insurance.component.html',
  styleUrls: ['./travel-insurance.component.css']
})
export class TravelComponent implements OnInit {

  exform: FormGroup;

  ngOnInit() {

  this.exform = new FormGroup({
    'manufacture' : new FormControl(null, Validators.required),
    'model' : new FormControl(null, [Validators.required]),
    'licence' : new FormControl(null, Validators.required),
    'registrationNo' : new FormControl(null, [Validators.required]),
    'engineNo' : new FormControl(null, Validators.required),
    'chaassisNo' : new FormControl(null, [Validators.required]),
    'planduration' : new FormControl(null, [Validators.required]),

    '' : new FormControl(
      null,
      [
        Validators.required,
        Validators.pattern('^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$')
      ]),
  });
  }

  clicksub() {
    console.log(this.exform.value);
    this.exform.reset();
  }
  get insuranceId() {
    return this.exform.get('insuranceId');
  }
  get userId() {
    return this.exform.get('userId');
  }
  get planId() {
    return this.exform.get('planId');
  }
  get location() {
    return this.exform.get('location');
  }
  get startDate() {
    return this.exform.get('startDate');
  }
  get endDate() {
    return this.exform.get('endDate');
  }
 }