import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminNutrionistEditComponent } from './admin-nutrionist-edit.component';

describe('AdminNutrionistEditComponent', () => {
  let component: AdminNutrionistEditComponent;
  let fixture: ComponentFixture<AdminNutrionistEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminNutrionistEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminNutrionistEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
