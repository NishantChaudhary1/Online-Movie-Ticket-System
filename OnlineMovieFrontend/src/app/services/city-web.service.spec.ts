import { TestBed } from '@angular/core/testing';

import { CityWebService } from './city-web.service';

describe('CityWebService', () => {
  let service: CityWebService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CityWebService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
