import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';
import { RenewRegisterVInsuranceDto } from '../renew-register-vinsurance-dto';
import { User } from '../user';
import { VehicleInsurance } from '../vehicle-insurance';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { VehicleServiceService } from '../vehicle-service.service';

@Component({
  selector: 'app-renew-insurance',
  templateUrl: './renew-insurance.component.html',
  styleUrls: ['./renew-insurance.component.css']
})
export class RenewInsuranceComponent implements OnInit {

  msg:string;
  plan = ['Silver','Gold','Diamond']
  planHasError = true;
  constructor(private renewInsuranceService:InsuranceService,private registerService:RegisterService,private vehicleService:VehicleServiceService) { }
  buyInsurance:VehicleInsurance=new VehicleInsurance();
  user:User=new User();
  renewDto:RenewRegisterVInsuranceDto=new RenewRegisterVInsuranceDto();
  arrays:number[]=[]; 
  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
  renewInsurance(){
    this.renewDto.userId=this.user.userId;
    console.log(this.renewDto);
    this.renewInsuranceService.renewinsurance(this.renewDto)
    .subscribe(message=>{
    this.msg=message
    alert(this.msg);
    location.reload();
    console.log(this.msg);
  }
)
  }
  getVInsuranceId(){
    this.vehicleService.getVInsuranceId(this.user.userName)
    .subscribe(
      obj=>{
        this.arrays=obj;
      }
    )
  }
  validatePlan(value:string) {
    if(value == 'default') {
      this.planHasError = true;
    }else {
      this.planHasError = false;
    }
  }
}
