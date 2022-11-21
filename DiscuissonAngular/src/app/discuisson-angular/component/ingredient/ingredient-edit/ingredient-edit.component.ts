import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Ingredient } from 'src/app/discuisson-angular/model/ingredient';
import { Unite } from 'src/app/discuisson-angular/model/unite';
import { IngredientService } from 'src/app/discuisson-angular/service/ingredient.service';

@Component({
  selector: 'app-ingredient-edit',
  templateUrl: './ingredient-edit.component.html',
  styleUrls: ['./ingredient-edit.component.css'],
})
export class IngredientEditComponent implements OnInit {
  ingredient: Ingredient = new Ingredient();

  constructor(
    private activatedRoute: ActivatedRoute,
    private ingredientService: IngredientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.ingredientService.findById(params['id']).subscribe((data) => {
          this.ingredient = data;
          console.log(this.ingredient.unite);

          if (this.ingredient.unite == 'g') {
            this.ingredient.unite = 'g';
          } else if (this.ingredient.unite == 'mL') {
            this.ingredient.unite = 'mL';
          }
        });
      } else {
        this.ingredient.dateDebutRecolte = 1;
        this.ingredient.dateFinRecolte = 12;
        this.ingredient.dateDebutRecolte = 1;
        this.ingredient.dateFinRecolte = 12;
        this.ingredient.vegetarien = true;
        this.ingredient.unite = 'g';
      }
    });
  }

  save() {
    if (this.ingredient.id) {
      this.ingredientService.update(this.ingredient).subscribe((data) => {
        this.router.navigateByUrl('/ingredient');
      });
    } else {
      this.ingredientService.create(this.ingredient).subscribe((data) => {
        this.router.navigateByUrl('/ingredient');
      });
    }
  }
}
