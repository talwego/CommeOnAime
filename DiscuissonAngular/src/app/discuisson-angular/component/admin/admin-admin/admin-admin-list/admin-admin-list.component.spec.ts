import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAdminListComponent } from './admin-admin-list.component';

describe('AdminAdminListComponent', () => {
  let component: AdminAdminListComponent;
  let fixture: ComponentFixture<AdminAdminListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAdminListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
