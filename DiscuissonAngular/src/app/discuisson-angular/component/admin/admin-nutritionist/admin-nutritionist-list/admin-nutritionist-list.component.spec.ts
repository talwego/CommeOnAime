import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminNutritionistListComponent } from './admin-nutritionist-list.component';

describe('AdminNutritionistListComponent', () => {
  let component: AdminNutritionistListComponent;
  let fixture: ComponentFixture<AdminNutritionistListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminNutritionistListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminNutritionistListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
