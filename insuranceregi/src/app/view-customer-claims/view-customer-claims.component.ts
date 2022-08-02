import { Component, OnInit } from '@angular/core';
import { ClaimServiceService } from '../claim-service.service';
import { User } from '../user';

@Component({
  selector: 'app-view-customer-claims',
  templateUrl: './view-customer-claims.component.html',
  styleUrls: ['./view-customer-claims.component.css']
})
export class ViewCustomerClaimsComponent implements OnInit {
  user:User=new User();
  name:string;
  viewUserClaims:any = new Array();
  constructor(private claimService:ClaimServiceService) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("userDetails"));
    this.name = this.user.userName;
    console.log(this.name);
    this.claimService.getCustomerClaims(this.name)
    .subscribe(
      obj=>{
        this.viewUserClaims=obj;
      }
    )
  }

}
