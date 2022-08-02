import { Component, OnInit } from '@angular/core';
import { ClaimInsurance } from '../claim-insurance';
import { ClaimServiceService } from '../claim-service.service';

@Component({
  selector: 'app-admin-verify-claim',
  templateUrl: './admin-verify-claim.component.html',
  styleUrls: ['./admin-verify-claim.component.css']
})
export class AdminVerifyClaimComponent implements OnInit {

  constructor(private claimService:ClaimServiceService) { }
viewClaims:any= new Array();
  ngOnInit(): void {
    this.claimService.viewAllUnverifiedClaims()
    .subscribe(
      obj=>{
        this.viewClaims=obj;
      }
    )
  }
Approve(id:number){
  this.claimService.approveOrReject(id,"Approved")
  .subscribe(
    data=>{
      if(data){
        location.reload();
      }
    }
  )
}
Reject(id:number){
  this.claimService.approveOrReject(id,"Rejected")
  .subscribe(
    data=>{
      if(data){
        location.reload();
      }
    }
  )
}
}
