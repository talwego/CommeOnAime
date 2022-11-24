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
  map: Map<number, number> = JSON.parse(sessionStorage.getItem('frigo')!);
  recettes: Recette[] = [];
  recettesSelection: Recette[] = [];

  constructor(private recetteService: RecetteService) {}

  ngOnInit(): void {
    this.recetteService.findAllWithDetails().subscribe((data) => {
      this.recettes = data;
      for (let obj of this.recettes) {
        if (obj.recetteIngredients) {
          for (let obj2 of obj.recetteIngredients) {
            for (let i = 0; i < this.map.size; i++) {
              if (
                this.map.has(obj2.id!) &&
                this.map.get(obj2.id!)! > obj2.quantite!
              ) {
                this.recettesSelection.push(obj);
              }
            }
          }
        }
      }
    });
  }
}
