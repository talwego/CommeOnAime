import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  static URL: string = 'http://localhost:8080/discuisson/api/admin';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>(AdminService.URL);
  }

  public findById(id: number): Observable<Admin> {
    return this.httpClient.get<Admin>(`${AdminService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${AdminService.URL}/${id}`);
  }

  public update(ingredient: Admin): Observable<Admin> {
    return this.httpClient.put<Admin>(
      `${AdminService.URL}/${ingredient?.id}`,
      ingredient
    );
  }

  public create(ingredient: Admin): Observable<Admin> {
    return this.httpClient.post<Admin>(
      AdminService.URL,
      this.adminToJson(ingredient)
    );
  }

  private adminToJson(admin: Admin): any {
    let JsonPourJava = {
      login: admin.login,
      password: admin.password,
    };
    return JsonPourJava;
  }
}
