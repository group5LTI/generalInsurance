import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { InsuranceDocumentDto } from './insurance-document-dto';

@Injectable({
  providedIn: 'root'
})
export class UploadDocumentServiceService {

  constructor(private httpClient:HttpClient) { }

  ToUpload(formData:FormData){
    return this.httpClient.post("http://localhost:9090/vehicles/upload-insurancedocument",formData,{responseType:'text'});
  }
  ToUploadClaim(formData:FormData){
    return this.httpClient.post("http://localhost:9090/claims/upload-claimdocument",formData,{responseType:'text'});
  }
}
