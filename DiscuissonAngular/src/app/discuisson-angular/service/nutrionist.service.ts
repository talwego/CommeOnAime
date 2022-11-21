import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nutritionist } from '../model/nutritionist';

@Injectable({
  providedIn: 'root',
})
export class NutrionistService {
  static URL: string = 'http://localhost:8080/discuisson/api/nutritionist';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Nutritionist[]> {
    return this.httpClient.get<Nutritionist[]>(NutrionistService.URL);
  }

  public findById(id: number): Observable<Nutritionist> {
    return this.httpClient.get<Nutritionist>(`${NutrionistService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${NutrionistService.URL}/${id}`);
  }

  public update(ingredient: Nutritionist): Observable<Nutritionist> {
    return this.httpClient.put<Nutritionist>(
      `${NutrionistService.URL}/${ingredient?.id}`,
      ingredient
    );
  }

  public create(ingredient: Nutritionist): Observable<Nutritionist> {
    return this.httpClient.post<Nutritionist>(
      NutrionistService.URL,
      this.adminToJson(ingredient)
    );
  }

  private adminToJson(nutrionist: Nutritionist): any {
    let JsonPourJava = {
      login: nutrionist.login,
      password: nutrionist.password,
    };
    return JsonPourJava;
  }
}
