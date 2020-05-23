import { TestBed } from '@angular/core/testing';

import { ShowWebService } from './show-web.service';

describe('ShowWebService', () => {
  let service: ShowWebService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowWebService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
