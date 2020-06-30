import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDishButtonComponent } from './add-dish-button.component';

describe('AddDishButtonComponent', () => {
  let component: AddDishButtonComponent;
  let fixture: ComponentFixture<AddDishButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDishButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDishButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
