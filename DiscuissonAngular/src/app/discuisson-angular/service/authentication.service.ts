import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) {}

  public isAuthenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  public authentication(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get('http://localhost:8080/eshop/api/auth', {
      headers: headers,
    });
  }
}
