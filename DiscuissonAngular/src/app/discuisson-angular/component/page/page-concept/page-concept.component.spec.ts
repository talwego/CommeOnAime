import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageConceptComponent } from './page-concept.component';

describe('PageConceptComponent', () => {
  let component: PageConceptComponent;
  let fixture: ComponentFixture<PageConceptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageConceptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageConceptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
