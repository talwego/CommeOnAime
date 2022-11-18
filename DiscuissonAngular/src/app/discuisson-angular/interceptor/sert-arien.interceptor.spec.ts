import { TestBed } from '@angular/core/testing';

import { SertARienInterceptor } from './sert-arien.interceptor';

describe('SertARienInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      SertARienInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: SertARienInterceptor = TestBed.inject(SertARienInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
