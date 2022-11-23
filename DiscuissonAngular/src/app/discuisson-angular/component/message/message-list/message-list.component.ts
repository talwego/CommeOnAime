import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from 'src/app/discuisson-angular/model/message';
import { MessageService } from 'src/app/discuisson-angular/service/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {
  messagesObservable!: Observable<Message[]>;

  constructor(private messageService: MessageService ) {}

  ngOnInit(): void {
    this.messagesObservable=this.messageService.findAll();
  }

  delete(id:number) {
    this.messageService.deleteById(id).subscribe(() => {
      this.messagesObservable=this.messageService.findAll();
    });
  }

}
