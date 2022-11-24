import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import { Message } from 'src/app/discuisson-angular/model/message';
import { MessageService } from 'src/app/discuisson-angular/service/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css'],
})
export class MessageListComponent implements OnInit {
  messages: Message[]=[];
  idconnecte: Number = JSON.parse(sessionStorage.getItem('compte')!).id;

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {
    interval(100).subscribe((data) => {
      this.initMessage();
    });
  }

  initMessage() {

    this.messageService.findAll().subscribe((data) =>{

      this.messages=data;
    }
    )
  }

  delete(id: number) {
    this.messageService.deleteById(id).subscribe(() => {
      this.initMessage();
    });
  }
}
