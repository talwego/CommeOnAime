import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingredient } from '../model/ingredient';

@Injectable({
  providedIn: 'root',
})
export class IngredientService {
  static URL: string = 'http://localhost:8080/discuisson/api/ingredient';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Ingredient[]> {
    return this.httpClient.get<Ingredient[]>(IngredientService.URL);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${IngredientService.URL}/${id}`);
  }
}
