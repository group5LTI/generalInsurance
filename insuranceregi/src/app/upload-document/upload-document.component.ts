import { InstantiateExpr } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { InsuranceDocument } from '../insurance-document';

@Component({
  selector: 'app-upload-document',
  templateUrl: './upload-document.component.html',
  styleUrls: ['./upload-document.component.css']
})
export class UploadDocumentComponent implements OnInit {
  insuranceDoc:InsuranceDocument =new InsuranceDocument();
  profilePic:any;
  constructor() { }

  ngOnInit(): void {
  }
//   onFileChange(event){
//     this.profilePic=event.target.files[0];
//   }
//   uploadDocumentInsurance(){ 
//   }
// uploadDoc(){
//   let formData=new FormData();
//   formData.append('userId',this.regResponse.userId.toString());
//   formData.append('profilePic',this.profilePic);
//   this.registerService.upload(formData)
//   .subscribe(data=>alert(JSON.stringify(data)));

// }
}
