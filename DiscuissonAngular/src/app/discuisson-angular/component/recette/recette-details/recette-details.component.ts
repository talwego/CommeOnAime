import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recette } from 'src/app/discuisson-angular/model/recette';
import { RecetteService } from 'src/app/discuisson-angular/service/recette.service';

@Component({
  selector: 'app-recette-details',
  templateUrl: './recette-details.component.html',
  styleUrls: ['./recette-details.component.css'],
})
export class RecetteDetailsComponent implements OnInit {
  recette: Recette = new Recette();
  urlImage: string = '';

  constructor(
    private activatedRoute: ActivatedRoute,
    private recetteService: RecetteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.urlImage =
          'assets/images/images-1-15/recette00' + params['id'] + '.jpg';
        console.log(this.urlImage);

        this.recetteService
          .findByIdWithDetails(params['id'])
          .subscribe((data) => {
            this.recette = data;
          });
      }
    });
  }
}
