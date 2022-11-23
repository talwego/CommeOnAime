import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-home-user',
  templateUrl: './page-home-user.component.html',
  styleUrls: ['./page-home-user.component.css']
})
export class PageHomeUserComponent implements OnInit {

  nom! : string

  constructor() { }

  ngOnInit(): void {
    if (sessionStorage.getItem('compte')) {
    this.nom = JSON.parse(sessionStorage.getItem( 'compte')!).login;
  }
}
}
