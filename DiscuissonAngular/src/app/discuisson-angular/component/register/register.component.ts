import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  login: string = '';
  password: string = '';
  showError = false;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (data) => {
        this.showError = false;
        sessionStorage.setItem('compte', JSON.stringify(data));
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.showError = true;
      },
    });
  }
}

