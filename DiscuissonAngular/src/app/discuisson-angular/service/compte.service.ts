import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  static URL: string = 'http://localhost:8080/discuisson/api/compte';

  constructor(private httpClient: HttpClient) {}

  public findById(id: number): Observable<Compte> {
    return this.httpClient.get<Compte>(`${CompteService.URL}/${id}`);
  }
}
