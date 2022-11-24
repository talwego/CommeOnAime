import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/app/discuisson-angular/model/message';
import { CompteService } from 'src/app/discuisson-angular/service/compte.service';
import { MessageService } from 'src/app/discuisson-angular/service/message.service';


@Component({
  selector: 'app-message-edit',
  templateUrl: './message-edit.component.html',
  styleUrls: ['./message-edit.component.css']
})
export class MessageEditComponent implements OnInit {
  message: Message = new Message();

  constructor(
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService,
    private router: Router,
    private compteService : CompteService
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

    this.compteService.findById(1).subscribe((data) => {
      this.message.envoyeur=data;
    });

    this.compteService.findById(9).subscribe((data) => {
      this.message.recepteur=data;
    });
    console.log('Save');
    console.log(this.message);


    this.messageService.create(this.message).subscribe((data) => {
        this.router.navigateByUrl('/message');
      });

    this.ngOnInit();
  }

}
