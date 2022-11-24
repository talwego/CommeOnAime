import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Recette } from 'src/app/discuisson-angular/model/recette';
import { RecetteService } from 'src/app/discuisson-angular/service/recette.service';

@Component({
  selector: 'app-frigo-selection',
  templateUrl: './frigo-selection.component.html',
  styleUrls: ['./frigo-selection.component.css'],
})
export class FrigoSelectionComponent implements OnInit {
  map!: Map<number, number>;
  recettes: Recette[] = [];
  recettesSelection: Recette[] = [];
  key!: number;
  value!: number;
  form!: FormGroup;

  constructor(private recetteService: RecetteService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      groupeing: new FormGroup({
        search: new FormControl(''),
      }),
    });
    let nombre = 0;
    this.map = this.gettfrigo;
    this.recettesSelection = [];
    this.recetteService.findAllWithDetails().subscribe((data) => {
      this.recettes = data;
      console.log(this.map);

      console.log(this.recettes);
      for (let obj of this.recettes) {
        if (obj.recetteIngredients) {
          for (let obj2 of obj.recetteIngredients) {
            for (let [key, value] of this.map) {
              if (obj2.ingredient?.id == key && value > obj2.quantite!) {
                nombre++;
              }
            }
          }
        }
        if (obj.recetteIngredients?.length! <= nombre) {
          this.recettesSelection.push(obj);
        }
        nombre = 0;
      }
    });
  }

  get gettfrigo(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('frigo')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    return panier;
  }

  chercher() {
    let nombreUser = this.form.get('groupeing.search')?.value;
    let nombre = 0;
    this.map = this.gettfrigo;
    this.recettesSelection = [];
    this.recetteService.findAllWithDetails().subscribe((data) => {
      this.recettes = data;
      console.log(this.map);

      console.log(this.recettes);
      for (let obj of this.recettes) {
        if (obj.recetteIngredients) {
          for (let obj2 of obj.recetteIngredients) {
            for (let [key, value] of this.map) {
              if (obj2.ingredient?.id == key && value > obj2.quantite!) {
                nombre++;
              }
            }
          }
        }
        if (
          nombreUser >= 0 &&
          obj.recetteIngredients?.length! <= nombre + nombreUser
        ) {
          this.recettesSelection.push(obj);
        }
        nombre = 0;
      }
      console.log(this.recettesSelection);
    });
  }

  reinit() {
    let nombre = 0;
    this.map = this.gettfrigo;
    this.recettesSelection = [];
    this.recetteService.findAllWithDetails().subscribe((data) => {
      this.recettes = data;
      console.log(this.map);

      console.log(this.recettes);
      for (let obj of this.recettes) {
        if (obj.recetteIngredients) {
          for (let obj2 of obj.recetteIngredients) {
            for (let [key, value] of this.map) {
              if (obj2.ingredient?.id == key && value > obj2.quantite!) {
                nombre++;
              }
            }
          }
        }
        if (obj.recetteIngredients?.length! <= nombre) {
          this.recettesSelection.push(obj);
        }
        nombre = 0;
      }
    });
  }
}
