import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientMenuComponent } from './ingredient-menu.component';

describe('IngredientMenuComponent', () => {
  let component: IngredientMenuComponent;
  let fixture: ComponentFixture<IngredientMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IngredientMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngredientMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
