import { TestBed } from '@angular/core/testing';

import { SizeInchService } from './size-inch.service';

describe('SizeInchService', () => {
  let service: SizeInchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SizeInchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
