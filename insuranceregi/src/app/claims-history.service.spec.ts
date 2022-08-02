import { TestBed } from '@angular/core/testing';

import { ClaimsHistoryService } from './claims-history.service';

describe('ClaimsHistoryService', () => {
  let service: ClaimsHistoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClaimsHistoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
