import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimInsuranceComponent } from './claim-insurance.component';

describe('ClaimInsuranceComponent', () => {
  let component: ClaimInsuranceComponent;
  let fixture: ComponentFixture<ClaimInsuranceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClaimInsuranceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClaimInsuranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
