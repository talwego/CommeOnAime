import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../../model/ingredient';
import { IngredientService } from '../../service/ingredient.service';

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.css'],
})
export class IngredientComponent implements OnInit {
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
