import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/app/discuisson-angular/model/message';
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
    private router: Router
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
    if (this.message.id) {
      this.messageService.update(this.message).subscribe((data) => {
        this.router.navigateByUrl('/message');
      });
    } else {
      this.messageService.create(this.message).subscribe((data) => {
        this.router.navigateByUrl('/message');
      });
    }
  }

}
