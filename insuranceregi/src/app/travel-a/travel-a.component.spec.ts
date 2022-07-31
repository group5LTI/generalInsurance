import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelAComponent } from './travel-a.component';

describe('TravelAComponent', () => {
  let component: TravelAComponent;
  let fixture: ComponentFixture<TravelAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TravelAComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TravelAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
