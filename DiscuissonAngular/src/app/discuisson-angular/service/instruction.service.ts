import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InstructionRecette } from '../model/instruction-recette';

@Injectable({
  providedIn: 'root',
})
export class InstructionService {
  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<InstructionRecette[]> {
    return this.httpClient.get<InstructionRecette[]>(
      'http://localhost:8080/discuisson/api/instructionRecette'
    );
  }

  public deleteById(id: number): Observable<InstructionRecette> {
    return this.httpClient.delete<InstructionRecette>(
      `http://localhost:8080/discuisson/api/instructionRecette/${id}`
    );
  }
  public findById(id: number): Observable<InstructionRecette> {
    return this.httpClient.get<InstructionRecette>(
      `http://localhost:8080/discuisson/api/instructionRecette/${id}`
    );
  }
  public update(obj: InstructionRecette): Observable<InstructionRecette> {
    return this.httpClient.put<InstructionRecette>(
      `http://localhost:8080/discuisson/api/instructionRecette/${obj?.id}`,
      obj
    );
  }

  public create(obj: InstructionRecette): Observable<InstructionRecette> {
    console.log('create');
    console.log(this.objToJson(obj));

    return this.httpClient.post<InstructionRecette>(
      'http://localhost:8080/discuisson/api/instructionRecette',
      this.objToJson(obj)
    );
  }
  private objToJson(obj: InstructionRecette): any {
    let recetteIngredientEnJsonPourJava = {
      instruction: obj.instruction,
      recette: {
        id: obj.recette?.id,
      },
    };
    return recetteIngredientEnJsonPourJava;
  }
}
