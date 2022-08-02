import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelCalculatorComponent } from './travel-calculator.component';

describe('TravelCalculatorComponent', () => {
  let component: TravelCalculatorComponent;
  let fixture: ComponentFixture<TravelCalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TravelCalculatorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TravelCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
