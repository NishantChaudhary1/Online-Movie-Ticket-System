import { TestBed } from '@angular/core/testing';

import { TheaterWebService } from './theater-web.service';

describe('TheaterWebService', () => {
  let service: TheaterWebService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TheaterWebService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
