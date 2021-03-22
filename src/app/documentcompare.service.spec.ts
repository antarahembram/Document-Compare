import { TestBed } from '@angular/core/testing';

import { DocumentcompareService } from './documentcompare.service';

describe('DocumentcompareService', () => {
  let service: DocumentcompareService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocumentcompareService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
