import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageHomeBackgroundComponent } from './page-home-background.component';

describe('PageHomeBackgroundComponent', () => {
  let component: PageHomeBackgroundComponent;
  let fixture: ComponentFixture<PageHomeBackgroundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageHomeBackgroundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageHomeBackgroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
