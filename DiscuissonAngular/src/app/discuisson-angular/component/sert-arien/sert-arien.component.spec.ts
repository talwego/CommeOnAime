import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SertARienComponent } from './sert-arien.component';

describe('SertARienComponent', () => {
  let component: SertARienComponent;
  let fixture: ComponentFixture<SertARienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SertARienComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SertARienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
