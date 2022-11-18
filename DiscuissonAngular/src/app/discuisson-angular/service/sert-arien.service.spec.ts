import { TestBed } from '@angular/core/testing';

import { SertARienService } from './sert-arien.service';

describe('SertARienService', () => {
  let service: SertARienService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SertARienService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
