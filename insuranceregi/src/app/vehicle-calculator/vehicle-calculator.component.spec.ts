import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleCalculatorComponent } from './vehicle-calculator.component';

describe('VehicleCalculatorComponent', () => {
  let component: VehicleCalculatorComponent;
  let fixture: ComponentFixture<VehicleCalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleCalculatorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehicleCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
