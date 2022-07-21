import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'buy-insurance',
  templateUrl: './buy-insurance.component.html',
  styleUrls: ['./buy-insurance.component.css']
})
export class BuyComponent implements OnInit {

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
  get manufacture() {
    return this.exform.get('manufacture');
  }
  get model() {
    return this.exform.get('model');
  }
  get licence() {
    return this.exform.get('licence');
  }
  get registrationNo() {
    return this.exform.get('registrationNo');
  }
  get engineNo() {
    return this.exform.get('engineNo');
  }
  get chassisNo() {
    return this.exform.get('chassisNo');
  }
 }