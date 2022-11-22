import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/discuisson-angular/model/admin';
import { AdminService } from 'src/app/discuisson-angular/service/admin.service';

@Component({
  selector: 'app-admin-admin-list',
  templateUrl: './admin-admin-list.component.html',
  styleUrls: ['./admin-admin-list.component.css'],
})
export class AdminAdminListComponent implements OnInit {
  admins: Admin[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.adminService.findAll().subscribe((data) => {
      this.admins = data;
    });
  }

  delete(id: number) {
    this.adminService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
