import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTheaterByCityAdminComponent } from './add-theater-by-city-admin.component';

describe('AddTheaterByCityAdminComponent', () => {
  let component: AddTheaterByCityAdminComponent;
  let fixture: ComponentFixture<AddTheaterByCityAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTheaterByCityAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTheaterByCityAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
