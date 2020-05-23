import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheaterAdminComponent } from './theater-admin.component';

describe('TheaterAdminComponent', () => {
  let component: TheaterAdminComponent;
  let fixture: ComponentFixture<TheaterAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheaterAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheaterAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
