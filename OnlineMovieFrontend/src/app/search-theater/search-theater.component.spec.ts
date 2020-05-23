import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchTheaterComponent } from './search-theater.component';

describe('SearchTheaterComponent', () => {
  let component: SearchTheaterComponent;
  let fixture: ComponentFixture<SearchTheaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchTheaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchTheaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
