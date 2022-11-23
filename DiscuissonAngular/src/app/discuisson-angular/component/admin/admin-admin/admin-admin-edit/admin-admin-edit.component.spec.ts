import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAdminEditComponent } from './admin-admin-edit.component';

describe('AdminAdminEditComponent', () => {
  let component: AdminAdminEditComponent;
  let fixture: ComponentFixture<AdminAdminEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAdminEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminAdminEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
