import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';
import { RenewVehicleInsurance } from '../renew-vehicle-insurance';
import { VehicleInsurance } from '../vehicle-insurance';

@Component({
  selector: 'app-renew-insurance',
  templateUrl: './renew-insurance.component.html',
  styleUrls: ['./renew-insurance.component.css']
})
export class RenewInsuranceComponent implements OnInit {

  renewVehcileInsurance:RenewVehicleInsurance=new RenewVehicleInsurance();
  msg:string;
  constructor(private renewInsuranceService:InsuranceService) { }
  buyInsurance:VehicleInsurance=new VehicleInsurance();
  ngOnInit(): void {
    this.buyInsurance=JSON.parse(sessionStorage.getItem("insuranceDetails"));
  }
  renewInsurance(){
this.renewInsuranceService.renewinsurance(this.buyInsurance)
.subscribe(
  renewVehcileInsurance=>{
    this.buyInsurance=renewVehcileInsurance.vehicleInsurance;
    this.msg=renewVehcileInsurance.message;
  }
)
  }

}
