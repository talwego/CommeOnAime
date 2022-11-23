import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from '../../model/compte';
import { User } from '../../model/user';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: string = '';
  password: string = '';
  showError = false;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (data) => {
        this.showError = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );

        sessionStorage.setItem('compte', JSON.stringify(data));

        if (data.role == 'ROLE_USER') {
          sessionStorage.setItem('role', 'user');
        } else if (data.role == 'ROLE_ADMIN'){
          sessionStorage.setItem('role', 'admin');
        }else
        sessionStorage.setItem('role', 'nutritionist');

        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.showError = true;
      },
    });
  }
}
