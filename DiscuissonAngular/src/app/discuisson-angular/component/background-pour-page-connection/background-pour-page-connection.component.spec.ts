import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackgroundPourPageConnectionComponent } from './background-pour-page-connection.component';

describe('BackgroundPourPageConnectionComponent', () => {
  let component: BackgroundPourPageConnectionComponent;
  let fixture: ComponentFixture<BackgroundPourPageConnectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BackgroundPourPageConnectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BackgroundPourPageConnectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
