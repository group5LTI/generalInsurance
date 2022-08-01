import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimInsurance } from '../claim-insurance';
import { ClaimInsuranceDto } from '../claim-insurance-dto';
import { ClaimServiceService } from '../claim-service.service';
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
  constructor( private claimService:ClaimServiceService,private router:Router) { }

  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
  addClaimInsurance(){
    this.claimInsuranceDto.userId=this.user.userId;
    this.claimService.addClaimInsurance(this.claimInsuranceDto)
    .subscribe(
      claiminsu=>{
        this.message=claiminsu;
        alert(this.message);
        this.router.navigate(['dbLink'])
      }
    )
  }
}
