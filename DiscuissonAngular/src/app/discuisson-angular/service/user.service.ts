import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  static URL: string = 'http://localhost:8080/discuisson/api/user';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(UserService.URL);
  }

  public findById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${UserService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${UserService.URL}/${id}`);
  }

  public update(ingredient: User): Observable<User> {
    return this.httpClient.put<User>(
      `${UserService.URL}/${ingredient?.id}`,
      ingredient
    );
  }

  public create(ingredient: any): Observable<User> {
    return this.httpClient.post<User>(
      UserService.URL,
      this.adminToJson(ingredient)
    );
  }

  private adminToJson(user: User): any {
    let JsonPourJava = {
      login: user.login,
      password: user.password,
      genre: user.genre,
      age: user.age,
      taille: user.taille,
      poids: user.poids,
      compteVIP: user.compteVIP,
      vegetarien: user.vegetarien,
      vegan: user.vegan,
    };
    return JsonPourJava;
  }
}
