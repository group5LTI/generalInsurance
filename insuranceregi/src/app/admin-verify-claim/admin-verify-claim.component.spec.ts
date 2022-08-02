import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminVerifyClaimComponent } from './admin-verify-claim.component';

describe('AdminVerifyClaimComponent', () => {
  let component: AdminVerifyClaimComponent;
  let fixture: ComponentFixture<AdminVerifyClaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminVerifyClaimComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminVerifyClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
