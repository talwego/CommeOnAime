import { Recette } from '../model/recette';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RecetteService {
  constructor(
    private httpClient: HttpClient,
  ) {}

  public findAll(): Observable<Recette[]> {
    return this.httpClient.get<Recette[]>(
      'http://localhost:8080/discuisson/api/recette'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/discuisson/api/recette/${id}`
    );
  }

  public findById(id: number): Observable<Recette> {
    return this.httpClient.get<Recette>(
      `http://localhost:8080/discuisson/api/recette/${id}`
    );
  }

  public update(recette: Recette): Observable<Recette> {
    console.debug(recette);
    return this.httpClient.put<Recette>(
      `http://localhost:8080/discuisson/api/recette/${recette?.id}`,
      recette
    );
  }

  public create(recette: Recette): Observable<Recette> {
    console.debug(recette);
    return this.httpClient.post<Recette>(
      'http://localhost:8080/discuisson/api/recette',
      this.recetteToJson(recette)
    );
  }

  private recetteToJson(recette: Recette): any {
    let recetteEnJsonPourJava = {
      name: recette.name,
      vegetarien: recette.vegetarien,
      vegan: recette.vegan,
      calorie: recette.calorie,
      debutSaison: recette.debutSaison,
      finSaison: recette.finSaison,
      commentaires: recette.commentaires,
      note: recette.note,
      tempsDeCuisine: recette.tempsDeCuisine,
      isValid: recette.isValid,
    };
    return recetteEnJsonPourJava;
  }
}

