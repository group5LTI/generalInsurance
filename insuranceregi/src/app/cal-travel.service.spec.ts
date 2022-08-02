import { TestBed } from '@angular/core/testing';

import { CalTravelService } from './cal-travel.service';

describe('CalTravelService', () => {
  let service: CalTravelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalTravelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
