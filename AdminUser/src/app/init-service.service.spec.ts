import { TestBed, inject } from '@angular/core/testing';

import { InitServiceService } from './init-service.service';

describe('InitServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InitServiceService]
    });
  });

  it('should be created', inject([InitServiceService], (service: InitServiceService) => {
    expect(service).toBeTruthy();
  }));
});
