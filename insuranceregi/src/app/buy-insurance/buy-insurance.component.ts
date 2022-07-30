import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BuyVInsuranceDto } from '../buy-vinsurance-dto';
import { Login } from '../login';
import { RegisterService } from '../register.service';
import { VehicleInsurance } from '../vehicle-insurance';
import { VehicleServiceService } from '../vehicle-service.service';
// import { Vehicle } from '../vehicle';



@Component({
  selector: 'buy-insurance',
  templateUrl: './buy-insurance.component.html',
  styleUrls: ['./buy-insurance.component.css']
})

export class BuyComponent implements OnInit {

  // buyRegDto:BuyRegisterVInsuranceDto=new BuyRegisterVInsuranceDto();
  buyDto:BuyVInsuranceDto = new BuyVInsuranceDto();
  plan = ['Silver','Gold','Diamond']
  planHasError = true;
  login:Login=new Login();
  vehicleInsurance:VehicleInsurance=new VehicleInsurance();
  isValid:boolean;
  msg:string;
  // vehicleModel = new vehicle('','','','','','','','','default');
  constructor(private vehicleService:VehicleServiceService,private registerService:RegisterService,private router:Router) {}
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
  }

  addVehicleInsurance() {

    this.buyDto.userId = 106;
    console.log(this.buyDto);
    console.log(this.login);
    this.vehicleService.addVehicleInsurance(this.buyDto)
    .subscribe(
      buyVehicleInsurance=>{
        this.isValid=buyVehicleInsurance;
        console.log(this.isValid);
        if(this.isValid){
          alert("Congratulations you have choosed "+this.buyDto.planType+" for your "+this.buyDto.vehicleType+" for "+this.buyDto.planDuration+" year/s");
          this.router.navigate(['paymentLink'])
        }
        else{
          alert("Right now "+this.buyDto.planType+" plan is not available for "+this.buyDto.vehicleType +" for "+this.buyDto.planDuration+" years");
        }
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
