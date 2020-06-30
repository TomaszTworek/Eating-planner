import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDishWindowComponent } from './add-dish-window.component';

describe('AddDishWindowComponent', () => {
  let component: AddDishWindowComponent;
  let fixture: ComponentFixture<AddDishWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDishWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDishWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
