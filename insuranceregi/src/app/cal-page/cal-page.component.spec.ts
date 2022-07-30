import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalPageComponent } from './cal-page.component';

describe('CalPageComponent', () => {
  let component: CalPageComponent;
  let fixture: ComponentFixture<CalPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
