import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/discuisson-angular/model/user';
import { UserService } from 'src/app/discuisson-angular/service/user.service';

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.css'],
})
export class AdminUserListComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.userService.findAll().subscribe((data) => {
      this.users = data;
    });
  }

  delete(id: number) {
    this.userService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
