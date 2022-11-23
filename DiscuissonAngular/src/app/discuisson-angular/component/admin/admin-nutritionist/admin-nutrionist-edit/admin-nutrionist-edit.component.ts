import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Nutritionist } from 'src/app/discuisson-angular/model/nutritionist';
import { AdminService } from 'src/app/discuisson-angular/service/admin.service';
import { NutrionistService } from 'src/app/discuisson-angular/service/nutrionist.service';

@Component({
  selector: 'app-admin-nutrionist-edit',
  templateUrl: './admin-nutrionist-edit.component.html',
  styleUrls: ['./admin-nutrionist-edit.component.css'],
})
export class AdminNutrionistEditComponent implements OnInit {
  nutrionist: Nutritionist = new Nutritionist();

  constructor(
    private activatedRoute: ActivatedRoute,
    private nutrionistService: NutrionistService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.nutrionistService.findById(params['id']).subscribe((data) => {
          this.nutrionist = data;
        });
      }
    });
  }

  save() {
    if (this.nutrionist.id) {
      this.nutrionistService.update(this.nutrionist).subscribe((data) => {
        this.router.navigateByUrl('/nutrionniste/nutrionniste');
      });
    } else {
      this.nutrionistService.create(this.nutrionist).subscribe((data) => {
        this.router.navigateByUrl('/nutrionniste/nutrionniste');
      });
    }
  }
}
