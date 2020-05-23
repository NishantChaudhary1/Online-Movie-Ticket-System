import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieAdminComponent } from './movie-admin.component';

describe('MovieAdminComponent', () => {
  let component: MovieAdminComponent;
  let fixture: ComponentFixture<MovieAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
