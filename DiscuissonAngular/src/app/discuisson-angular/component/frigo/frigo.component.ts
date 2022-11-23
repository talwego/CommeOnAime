import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Ingredient } from '../../model/ingredient';
import { IngredientService } from '../../service/ingredient.service';

@Component({
  selector: 'app-frigo',
  templateUrl: './frigo.component.html',
  styleUrls: ['./frigo.component.css'],
})
export class FrigoComponent implements OnInit {
  nom: string = '';
  ingredients: Ingredient[] = [];

  constructor(private ingredientService: IngredientService) {}

  ngOnInit(): void {
    if (!sessionStorage.getItem('panier')) {
      sessionStorage.setItem(
        'panier',
        JSON.stringify(new Map<number, number>())
      );
    }
    this.ingredientService.findAll().subscribe((data) => {
      this.ingredients = data;
    });
  }

  ajouterPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.has(id)) {
      map.set(id, map.get(id)! + 100);
    } else {
      map.set(id, 100);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  retirerPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.get(id) == 100) {
      map.delete(id);
    } else {
      map.set(id, map.get(id)! - 100);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  supprimerPanier(id: number) {
    let map: Map<number, number> = this.panier;
    map.delete(id);
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    return panier;
  }

  getQuantite(id: number): number {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    return jsonObject[id];
  }

  chercher() {
    this.ingredientService.findByName(this.nom).subscribe((data) => {
      console.log('koukou');
      this.ingredients = data;
    });
  }
}
