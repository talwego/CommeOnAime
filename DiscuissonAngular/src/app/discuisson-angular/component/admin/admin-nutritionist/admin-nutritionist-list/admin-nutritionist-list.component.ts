import { Component, OnInit } from '@angular/core';
import { Nutritionist } from 'src/app/discuisson-angular/model/nutritionist';
import { NutrionistService } from 'src/app/discuisson-angular/service/nutrionist.service';

@Component({
  selector: 'app-admin-nutritionist-list',
  templateUrl: './admin-nutritionist-list.component.html',
  styleUrls: ['./admin-nutritionist-list.component.css'],
})
export class AdminNutritionistListComponent implements OnInit {
  nutritionists: Nutritionist[] = [];

  constructor(private nutrionistService: NutrionistService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.nutrionistService.findAll().subscribe((data) => {
      this.nutritionists = data;
    });
  }

  delete(id: number) {
    this.nutrionistService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
