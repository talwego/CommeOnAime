import { Component, OnInit } from '@angular/core';
import { Message } from 'src/app/discuisson-angular/model/message';
import { MessageService } from 'src/app/discuisson-angular/service/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {
  messages: Message[]=[];

  constructor(private messageService: MessageService ) {}

  ngOnInit(): void {
    this.initMessage();
  }

  initMessage() {
    this.messageService.findAll().subscribe((data) =>{
      this.messages = data;
    }
    )
  }

  delete(id:number) {
    this.messageService.deleteById(id).subscribe(() => {
      this.initMessage();
    });
  }

}
