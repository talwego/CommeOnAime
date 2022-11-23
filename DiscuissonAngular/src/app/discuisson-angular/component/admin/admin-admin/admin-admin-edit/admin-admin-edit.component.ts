import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/discuisson-angular/model/admin';
import { AdminService } from 'src/app/discuisson-angular/service/admin.service';

@Component({
  selector: 'app-admin-admin-edit',
  templateUrl: './admin-admin-edit.component.html',
  styleUrls: ['./admin-admin-edit.component.css'],
})
export class AdminAdminEditComponent implements OnInit {
  admin: Admin = new Admin();

  constructor(
    private activatedRoute: ActivatedRoute,
    private adminService: AdminService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.adminService.findById(params['id']).subscribe((data) => {
          this.admin = data;
        });
      }
    });
  }

  save() {
    if (this.admin.id) {
      this.adminService.update(this.admin).subscribe((data) => {
        this.router.navigateByUrl('/admin/admin');
      });
    } else {
      this.adminService.create(this.admin).subscribe((data) => {
        this.router.navigateByUrl('/admin/admin');
      });
    }
  }
}
