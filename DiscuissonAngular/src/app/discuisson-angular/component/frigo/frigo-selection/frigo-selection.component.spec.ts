import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrigoSelectionComponent } from './frigo-selection.component';

describe('FrigoSelectionComponent', () => {
  let component: FrigoSelectionComponent;
  let fixture: ComponentFixture<FrigoSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrigoSelectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FrigoSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
