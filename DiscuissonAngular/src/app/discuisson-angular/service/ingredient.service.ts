import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingredient } from '../model/ingredient';
import { Unite } from '../model/unite';

@Injectable({
  providedIn: 'root',
})
export class IngredientService {
  static URL: string = 'http://localhost:8080/discuisson/api/ingredient';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Ingredient[]> {
    return this.httpClient.get<Ingredient[]>(IngredientService.URL);
  }

  public findById(id: number): Observable<Ingredient> {
    return this.httpClient.get<Ingredient>(`${IngredientService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${IngredientService.URL}/${id}`);
  }

  public update(ingredient: Ingredient): Observable<Ingredient> {
    return this.httpClient.put<Ingredient>(
      `${IngredientService.URL}/${ingredient?.id}`,
      ingredient
    );
  }

  public create(ingredient: Ingredient): Observable<Ingredient> {
    return this.httpClient.post<Ingredient>(
      IngredientService.URL,
      this.ingredientToJson(ingredient)
    );
  }

  private ingredientToJson(ingredient: Ingredient): any {
    let ingredientEnJsonPourJava = {
      name: ingredient.name,
      calorie: ingredient.calorie,
      dateDebutRecolte: ingredient.dateDebutRecolte,
      dateFinRecolte: ingredient.dateFinRecolte,
      vegan: ingredient.vegan,
      vegetarien: ingredient.vegetarien,
      unite: ingredient.unite,
    };
    return ingredientEnJsonPourJava;
  }
}
