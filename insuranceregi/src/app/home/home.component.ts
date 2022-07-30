import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private registerService:RegisterService) { }
  customer:User=new User();
  ngOnInit(): void {
    this.customer = JSON.parse(sessionStorage.getItem("userDetails"));
    console.log(this.customer);
  }

}
