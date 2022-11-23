import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrigoBackgroundComponent } from './frigo-background.component';

describe('FrigoBackgroundComponent', () => {
  let component: FrigoBackgroundComponent;
  let fixture: ComponentFixture<FrigoBackgroundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrigoBackgroundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FrigoBackgroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
