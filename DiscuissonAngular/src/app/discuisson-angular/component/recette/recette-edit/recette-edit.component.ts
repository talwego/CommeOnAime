import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ingredient } from 'src/app/discuisson-angular/model/ingredient';
import { Recette } from 'src/app/discuisson-angular/model/recette';
import { IngredientService } from 'src/app/discuisson-angular/service/ingredient.service';
import { RecetteService } from 'src/app/discuisson-angular/service/recette.service';
import { RecetteIngredientService } from 'src/app/discuisson-angular/service/recette-ingredient.service';
import { RecetteIngredient } from 'src/app/discuisson-angular/model/recette-ingredient';

@Component({
  selector: 'app-recette-edit',
  templateUrl: './recette-edit.component.html',
  styleUrls: ['./recette-edit.component.css'],
})
export class RecetteEditComponent implements OnInit {
  recette: Recette = new Recette();
  ingredients: Ingredient[] = [];
  recetteIngredients: RecetteIngredient[] = [];
  recetteIngredient: RecetteIngredient = new RecetteIngredient();

  constructor(
    private activatedRoute: ActivatedRoute,
    private recetteService: RecetteService,
    private router: Router,
    private ingredientService: IngredientService,
    private recetteIngredientService: RecetteIngredientService
  ) {}

  ngOnInit(): void {
    this.ingredientService.findAll().subscribe((data) => {
      this.ingredients = data;
    });
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.recetteService
          .findByIdWithDetails(params['id'])
          .subscribe((data) => {
            this.recette = data;
            this.recetteIngredient.recette = new Recette();
            this.recetteIngredient.recette.id = this.recette.id;
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
  saveRecetteIngredient() {
    console.log(this.recetteIngredient);
    if (this.recetteIngredient.id) {
      this.recetteIngredientService
        .update(this.recetteIngredient)
        .subscribe((data) => {
          this.router.navigateByUrl('/recetteIngredient');
        });
    } else {
      this.recetteIngredientService
        .create(this.recetteIngredient)
        .subscribe((data) => {
          this.router.navigateByUrl('/recetteIngredient');
        });
    }
  }
  deleteRecetteIngredient(id: number) {
    this.recetteIngredientService.deleteById(id).subscribe(() => {
      this.initRecetteIngredient();
    });
  }
  initRecetteIngredient() {
    this.recetteIngredientService.findAll().subscribe((data) => {
      this.recetteIngredients = data;
    });
  }
  byId(obj1: Ingredient, obj2: Ingredient) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    return false;
  }
}
