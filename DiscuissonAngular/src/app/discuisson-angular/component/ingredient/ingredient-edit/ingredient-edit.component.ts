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
        });
      } else {
        this.ingredient.dateDebutRecolte = 1;
        this.ingredient.dateFinRecolte = 12;
        this.ingredient.vegan = false;
        this.ingredient.vegetarien = false;
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
    console.log('vegan: ' + this.ingredient.vegan);
    console.log('vegetarien: ' + this.ingredient.vegetarien);
    console.log('unite: ' + this.ingredient.unite);
  }
}
