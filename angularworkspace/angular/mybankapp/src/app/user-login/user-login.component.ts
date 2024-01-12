import { Component, OnInit } from '@angular/core';
import { UserLogin } from '../user-login';
import { ActivatedRoute, Router } from '@angular/router';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent{
  user: UserLogin;
  responseMessage: string;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private userLoginService: UserLoginService) {
    this.user = new UserLogin();
  }

  OnSubmit() {
    this.userLoginService.login(this.user).subscribe((response: any) => {
      alert(response);
      console.log(response)
  },result => this.gotoUserLoginList());
  }
  
  gotoUserLoginList() {
    this.router.navigate(['user/getusers']);
    
  }
}

