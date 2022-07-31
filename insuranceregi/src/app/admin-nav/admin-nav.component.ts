import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-admin-nav',
  templateUrl: './admin-nav.component.html',
  styleUrls: ['./admin-nav.component.css']
})
export class AdminNavComponent implements OnInit {
user:User = new User();
  constructor(private registerService:RegisterService,private router:Router) { }

  ngOnInit(): void {
    this.user=JSON.parse(sessionStorage.getItem("userDetails"));
  }
  checkLUser(){
    this.router.navigate(['/homeLink']);
  }
  checkHUser(){
    if(this.user.userName=="Admin"){
      this.router.navigate(['/adminLink'])
    }
    else{
      this.router.navigate(['/dbLink']);
    }

  }


}
