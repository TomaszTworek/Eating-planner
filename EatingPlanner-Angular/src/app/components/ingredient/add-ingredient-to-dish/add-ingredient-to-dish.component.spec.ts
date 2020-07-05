import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIngredientToDishComponent } from './add-ingredient-to-dish.component';

describe('AddIngredientToDishComponent', () => {
  let component: AddIngredientToDishComponent;
  let fixture: ComponentFixture<AddIngredientToDishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddIngredientToDishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIngredientToDishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
