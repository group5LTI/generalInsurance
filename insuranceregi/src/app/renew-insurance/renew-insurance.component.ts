import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';
import { RenewRegisterVInsuranceDto } from '../renew-register-vinsurance-dto';
import { User } from '../user';
import { VehicleInsurance } from '../vehicle-insurance';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-renew-insurance',
  templateUrl: './renew-insurance.component.html',
  styleUrls: ['./renew-insurance.component.css']
})
export class RenewInsuranceComponent implements OnInit {

  msg:string;
  constructor(private renewInsuranceService:InsuranceService,private registerService:RegisterService) { }
  buyInsurance:VehicleInsurance=new VehicleInsurance();
  user:User=new User();
  renewDto:RenewRegisterVInsuranceDto=new RenewRegisterVInsuranceDto();
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
    console.log(this.msg);
  }
)
  }

}
