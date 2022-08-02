import { Component, OnInit } from '@angular/core';
import { TravelServiceService } from '../travel-service.service';
import { Router } from '@angular/router';
import { BuyTinsuranceDto } from '../buy-tinsurance-dto';
import { Login } from '../login';
import { User } from '../user';
import { TravelInsurance } from '../travel-insurance';
import { RegisterService } from '../register.service';
import { InsuranceDocumentDto } from '../insurance-document-dto';
import { UploadDocumentServiceService } from '../upload-document-service.service';

@Component({
  selector: 'travel-insurance',
  templateUrl: './travel-insurance.component.html',
  styleUrls: ['./travel-insurance.component.css']
})
export class TravelComponent implements OnInit {

  buyTDto:BuyTinsuranceDto = new BuyTinsuranceDto();
  docDto:InsuranceDocumentDto = new InsuranceDocumentDto();
  plan = ['Silver','Gold','Diamond']
  planHasError = true;
  login:Login = new Login();
  travelInsurance:TravelInsurance = new TravelInsurance();
  isValid:boolean;
  msg:string;
  user:User = new User();

  // travelModel = new Travel('','','','default');
  constructor(private travelService:TravelServiceService,private router:Router,private registerService:RegisterService,private uploadDocumemt:UploadDocumentServiceService) {}


  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("userDetails"));
   }

  addTravelInsurance() {
    console.log(this.user.userId);
    console.log(this.buyTDto)
    this.buyTDto.userId = this.user.userId;
    this.travelService.addTravelInsurance(this.buyTDto).subscribe(
      buytravelInsurance=> {
        this.travelInsurance=buytravelInsurance;
        // console.log(this.isValid);
        this.docDto.insuranceId=buytravelInsurance.travelInsuranceId;
        console.log(this.travelInsurance);
        if(this.travelInsurance!=null) {
          alert("Congratulations your travel insurance id is "+buytravelInsurance.travelInsuranceId);
          alert("Upload Documents");
        }
        else {
          alert("Some error Occurred");
        }
      }
    )
  }
  validatePlan(value:String) {
    if(value == 'default') {
      this.planHasError = true;
    }else {
      this.planHasError = false;
    }
  }
  onFileChange(event){
    this.docDto.insuranceDocument=event.target.files[0];
  }
  ToUpload(){
  let formData=new FormData();
  this.docDto.userId=this.buyTDto.userId;
  console.log(this.docDto.userId);
  console.log('--------------------------------');
  this.docDto.insuranceDocument=this.docDto.insuranceDocument;
  formData.append('userId',this.docDto.userId.toString());
  formData.append('insuranceId',this.docDto.insuranceId.toString());
  formData.append('insuranceDocument',this.docDto.insuranceDocument);
  this.uploadDocumemt.ToUpload(formData)
  .subscribe(data=>alert(JSON.stringify(data)));
  location.reload();
}
}
