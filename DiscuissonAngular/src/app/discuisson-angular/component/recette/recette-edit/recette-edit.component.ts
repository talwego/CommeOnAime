import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ingredient } from 'src/app/discuisson-angular/model/ingredient';
import { Recette } from 'src/app/discuisson-angular/model/recette';
import { IngredientService } from 'src/app/discuisson-angular/service/ingredient.service';
import { RecetteService } from 'src/app/discuisson-angular/service/recette.service';

@Component({
  selector: 'app-recette-edit',
  templateUrl: './recette-edit.component.html',
  styleUrls: ['./recette-edit.component.css'],
})
export class RecetteEditComponent implements OnInit {
  recette: Recette = new Recette();
  ingredients: Ingredient[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private recetteService: RecetteService,
    private router: Router,
    private ingredientService: IngredientService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.recetteService.findById(params['id']).subscribe((data) => {
          this.recette = data;
        });
      }
    });
  }

  save() {
    if (this.recette.id) {
      this.recetteService.update(this.recette).subscribe((data) => {
        this.router.navigateByUrl('/recette');
      });
    } else {
      this.recetteService.create(this.recette).subscribe((data) => {
        this.router.navigateByUrl('/recette');
      });
    }
  }
}
