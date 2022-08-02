import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BuyVInsuranceDto } from '../buy-vinsurance-dto';
import { InsuranceDocumentDto } from '../insurance-document-dto';
import { Login } from '../login';
import { RegisterService } from '../register.service';
import { UploadDocumentServiceService } from '../upload-document-service.service';
import { User } from '../user';
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
  docDto:InsuranceDocumentDto = new InsuranceDocumentDto();
  plan = ['Silver','Gold','Diamond']
  planHasError = true;
  login:Login=new Login();
  vehicleInsurance:VehicleInsurance=new VehicleInsurance();
  msg:string;
  user:User=new User();

  // vehicleModel = new vehicle('','','','','','','','','default');
  constructor(private vehicleService:VehicleServiceService,private registerService:RegisterService,private router:Router,private uploadDocumemt:UploadDocumentServiceService) {}
  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }

  addVehicleInsurance() {

    this.buyDto.userId = this.user.userId;
    console.log(this.user.userId);
    console.log(this.buyDto);
    console.log(this.user);
    this.vehicleService.addVehicleInsurance(this.buyDto)
    .subscribe(
      buyVehicleInsurance=>{
        this.vehicleInsurance=buyVehicleInsurance;
        this.docDto.insuranceId=this.vehicleInsurance.vehicleInsuranceId;
        console.log(this.vehicleInsurance);
        if(this.vehicleInsurance!=null){
          alert("Congratulations you have choosed "+this.buyDto.planType+" for your "+this.buyDto.vehicleType+" for "+this.buyDto.planDuration+" year/s");
          alert("Upload documents");
        }
        else{
          alert("Right now "+this.buyDto.planType+" plan is not available for "+this.buyDto.vehicleType +" for "+this.buyDto.planDuration+" years");
        }
      }
    )
  }   
  onFileChange(event){
    this.docDto.insuranceDocument=event.target.files[0];
  }
  validatePlan(value:string) {
    if(value == 'default') {
      this.planHasError = true;
    }else {
      this.planHasError = false;
    }
  }
ToUpload(){
  let formData=new FormData();
  this.docDto.userId=this.buyDto.userId;
  this.docDto.insuranceDocument=this.docDto.insuranceDocument;
  formData.append('userId',this.docDto.userId.toString());
  formData.append('insuranceId',this.docDto.insuranceId.toString());
  formData.append('insuranceDocument',this.docDto.insuranceDocument);
  this.uploadDocumemt.ToUpload(formData)
  .subscribe(data=>alert(JSON.stringify(data)));
  location.reload();
}
  
}
