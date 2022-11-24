import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/app/discuisson-angular/model/message';
import { CompteService } from 'src/app/discuisson-angular/service/compte.service';
import { MessageService } from 'src/app/discuisson-angular/service/message.service';
import { MessageListComponent } from '../message-list/message-list.component';

@Component({
  selector: 'app-message-edit',
  templateUrl: './message-edit.component.html',
  styleUrls: ['./message-edit.component.css'],
})
export class MessageEditComponent implements OnInit {
  message: Message = new Message();

  constructor(
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService,
    private router: Router,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.messageService.findById(params['id']).subscribe((data) => {
          this.message = data;
        });
      }
    });
  }

  save() {
    this.compteService.findById(JSON.parse(sessionStorage.getItem('compte')!).id).subscribe((data1) => {
      this.message.envoyeur = data1;
      this.compteService.findById(9).subscribe((data2) => {
        this.message.recepteur = data2;
        this.messageService.create(this.message).subscribe((data) => {
          this.router
            .navigateByUrl('/message/edit', { skipLocationChange: true })
            .then(() => {
              this.router.navigate(['/message']);
            });
        });
      });
    });
  }
}
