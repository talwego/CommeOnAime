import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RecetteIngredient } from '../model/recette-ingredient';

@Injectable({
  providedIn: 'root'
})
export class RecetteIngredientService {

  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<RecetteIngredient[]> {
    return this.httpClient.get<RecetteIngredient[]>(
      'http://localhost:8080/discuisson/api/recetteIngredient'
    );
  }

  
  public deleteById(id: number): Observable<RecetteIngredient> {
    return this.httpClient.delete<RecetteIngredient>(
      `http://localhost:8080/discuisson/api/recetteIngredient/${id}`
    );
  }
  public findById(id: number): Observable<RecetteIngredient> {
    return this.httpClient.get<RecetteIngredient>(
      `http://localhost:8080/discuisson/api/recetteIngredient/${id}`
    );
  }
  public update(recetteIngredient: RecetteIngredient): Observable<RecetteIngredient> {
    console.debug(recetteIngredient);
    return this.httpClient.put<RecetteIngredient>(
      `http://localhost:8080/discuisson/api/recetteIngredient/${recetteIngredient?.id}`,
      recetteIngredient
    );
  }

  public create(recetteIngredient: RecetteIngredient): Observable<RecetteIngredient> {
    console.debug(recetteIngredient);
    return this.httpClient.post<RecetteIngredient>(
      'http://localhost:8080/discuisson/api/recetteIngredient',
      this.recetteIngredientToJson(recetteIngredient)
    );
  }
  private recetteIngredientToJson(recetteIngredient: RecetteIngredient): any {
    let recetteIngredientEnJsonPourJava = {
      quantite: recetteIngredient.quantite,
      ingredient_id: recetteIngredient.ingredient,
      recette_id: recetteIngredient.recette,
      
    };
    return recetteIngredientEnJsonPourJava;
  }
}
