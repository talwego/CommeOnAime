import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { IngredientService } from 'src/app/discuisson-angular/service/ingredient.service';
import { FrigoComponent } from '../frigo.component';

@Component({
  selector: 'app-frigo-background',
  templateUrl: './frigo-background.component.html',
  styleUrls: ['./frigo-background.component.css'],
})
export class FrigoBackgroundComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
}
