import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserToVIPComponent } from './user-to-vip.component';

describe('UserToVIPComponent', () => {
  let component: UserToVIPComponent;
  let fixture: ComponentFixture<UserToVIPComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserToVIPComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserToVIPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
