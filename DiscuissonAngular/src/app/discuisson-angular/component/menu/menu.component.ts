import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  logoff() {
    //sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }
  /*
  get admin() {
    return this.authSrv.isAdmin();
  }

  get nutritionist() {
    return this.authSrv.isNutritionist();
  }

  get user() {
    return this.authSrv.isUser();
  }

  get vip() {
    return this.authSrv.isVip();
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }

  get authenticated() {
    return this.authSrv.isAuthenticated();
  }*/
}
