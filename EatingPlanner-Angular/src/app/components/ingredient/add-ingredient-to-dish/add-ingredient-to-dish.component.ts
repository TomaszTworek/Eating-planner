import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Ingredient} from "../../../models/ingredient";

@Component({
  selector: 'app-add-ingredient-to-dish',
  templateUrl: './add-ingredient-to-dish.component.html',
  styleUrls: ['./add-ingredient-to-dish.component.css']
})
export class AddIngredientToDishComponent implements OnInit {

  ingredients: Ingredient[] = [];

  @Output() event = new EventEmitter<Ingredient[]>();

  constructor() {
  }

  ngOnInit(): void {
  }

  addIngredientToDish(name: string, units: string, calories: number) {
    console.log("NAME" + name)
    let ingredient = new Ingredient(name, units, calories);
    console.log("TERAZ" + ingredient.name);
    this.ingredients.push(ingredient);
    this.event.emit(this.ingredients);
  }
}
