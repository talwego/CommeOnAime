import { TestBed } from '@angular/core/testing';

import { RecetteIngredientService } from './recette-ingredient.service';

describe('RecetteIngredientService', () => {
  let service: RecetteIngredientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecetteIngredientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
