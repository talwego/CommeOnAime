
/*import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  static URL: string = 'http://localhost:8080/discuisson/api/user';

  constructor(private httpClient: HttpClient) {}

  public inscription(user: any): Observable<User> {
    return this.httpClient.post<User>(
      `${UserService.URL}/inscription`,
      user
    );
  }

  public checkLoginExists(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${UserService.URL}/check/login/${login}`
    );
  }
}
*/
