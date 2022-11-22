import { TestBed } from '@angular/core/testing';

import { NutrionistService } from './nutrionist.service';

describe('NutrionistService', () => {
  let service: NutrionistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NutrionistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
