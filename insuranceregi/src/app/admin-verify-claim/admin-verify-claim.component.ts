import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-verify-claim',
  templateUrl: './admin-verify-claim.component.html',
  styleUrls: ['./admin-verify-claim.component.css']
})
export class AdminVerifyClaimComponent implements OnInit {

  constructor(private router:Router,private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

}
