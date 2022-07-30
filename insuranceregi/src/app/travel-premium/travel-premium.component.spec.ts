import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelPremiumComponent } from './travel-premium.component';

describe('TravelPremiumComponent', () => {
  let component: TravelPremiumComponent;
  let fixture: ComponentFixture<TravelPremiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TravelPremiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TravelPremiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
