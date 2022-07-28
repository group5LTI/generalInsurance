import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user:User=new User();
message:string;
  constructor(private registerService:RegisterService) { }

  ngOnInit(): void {
  }
register()
{
console.log(JSON.stringify(this.user));
this.registerService.registerUser(this.user)
    .subscribe(
      msg=>{
        this.message=msg;
        console.log(JSON.stringify(this.message));
      }
    );
}
}
