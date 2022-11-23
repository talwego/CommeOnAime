import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../model/message';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  static URL: string = 'http://localhost:8080/discuisson/api/message';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Message[]> {
    return this.httpClient.get<Message[]>(MessageService.URL);
  }

  public findById(id: number): Observable<Message> {
    return this.httpClient.get<Message>(`${MessageService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${MessageService.URL}/${id}`);
  }

  public update(message: Message): Observable<Message> {
    return this.httpClient.put<Message>(
      `${MessageService.URL}/${message.id}`,
      message
    );
  }

  public create(message: Message): Observable<Message> {
    return this.httpClient.post<Message>(
      MessageService.URL,
      this.messageToJson(message)
    );
  }

  public messageToJson(message: Message): any {
    let messageJson = {
      text: message.text,
      envoyeur: message.envoyeur,
      recepteur: message.recepteur,
    };
    if (message.id) {
      Object.assign(messageJson, { id: message.id });
    }
    return messageJson;
  }


}
