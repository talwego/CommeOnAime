import { Component, OnInit } from '@angular/core';
import { Ingredient } from 'src/app/discuisson-angular/model/ingredient';
import { IngredientService } from 'src/app/discuisson-angular/service/ingredient.service';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css'],
})
export class IngredientListComponent implements OnInit {
  ingredients: Ingredient[] = [];

  constructor(private ingredientService: IngredientService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.ingredientService.findAll().subscribe((data) => {
      this.ingredients = data;
    });
  }

  delete(id: number) {
    this.ingredientService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
