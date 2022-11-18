import { Component, OnInit } from '@angular/core';
import { Recette } from 'src/app/discuisson-angular/model/recette';

@Component({
  selector: 'app-recette-list',
  templateUrl: './recette-list.component.html',
  styleUrls: ['./recette-list.component.css']
})
export class RecetteListComponent implements OnInit {
recettes: Recette[] = [];

  constructor(private recetteService: RecetteService) {}

  ngOnInit(): void {
    this.initRecette();
  }

  initProduit() {
    this.recetteService.findAll().subscribe((data) => {
      this.recettes = data;
    });
  }

  delete(id: number) {
    this.recetteService.deleteById(id).subscribe(() => {
      this.initRecette();
    });
  }
}
