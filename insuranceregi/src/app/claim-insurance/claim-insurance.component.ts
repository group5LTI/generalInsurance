import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimDocumentDto } from '../claim-document-dto';
import { ClaimInsurance } from '../claim-insurance';
import { ClaimInsuranceDto } from '../claim-insurance-dto';
import { ClaimServiceService } from '../claim-service.service';
import { UploadDocumentServiceService } from '../upload-document-service.service';
import { User } from '../user';

@Component({
  selector: 'app-claim-insurance',
  templateUrl: './claim-insurance.component.html',
  styleUrls: ['./claim-insurance.component.css']
})
export class ClaimInsuranceComponent implements OnInit {
user:User=new User();
message:string;
claiminsurance:ClaimInsurance=new ClaimInsurance();
  claimInsuranceDto:ClaimInsuranceDto=new ClaimInsuranceDto();
  claimdocDto:ClaimDocumentDto = new ClaimDocumentDto();
  constructor( private claimService:ClaimServiceService,private router:Router,private uploadDocumemt:UploadDocumentServiceService) { }

  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
  addClaimInsurance(){
    this.claimInsuranceDto.userId=this.user.userId;
    this.claimService.addClaimInsurance(this.claimInsuranceDto)
    .subscribe(
      claiminsu=>{
        this.claiminsurance=claiminsu;
        this.claimdocDto.claimId=claiminsu.claimId;
        if(this.claiminsurance!=null){
          alert("Claim submitted your id = "+this.claiminsurance.claimId);
        }
        else{
          alert("Some Error occured");
        }
      }
    )
  }
  onFileChange(event){
    this.claimdocDto.claimInsuranceDocument=event.target.files[0];
  }
  UploadClaim(){
    let formData=new FormData();
    this.claimdocDto.userId=this.user.userId;
    this.claimdocDto.claimInsuranceDocument=this.claimdocDto.claimInsuranceDocument;
    formData.append('claimId',this.claimdocDto.claimId.toString());
    formData.append('userId',this.claimdocDto.userId.toString());
    formData.append('claimInsuranceDocument',this.claimdocDto.claimInsuranceDocument);
    this.uploadDocumemt.ToUploadClaim(formData)
    .subscribe(
      data=>{
        console.log(data)
       
      }


    );
    alert("File Uploaded");
    location.reload();
  }
}
