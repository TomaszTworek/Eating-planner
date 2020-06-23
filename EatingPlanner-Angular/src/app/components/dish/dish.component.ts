import {Component, OnInit} from '@angular/core';
import {Ingredient} from "../../models/ingredient";
import {ApiIngredientService} from "../../services/api-ingredient.service";
import {IngredientViewModel} from "../ingredient/ingredient.component";
import {Dish} from "../../models/dish";
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishCategory} from "../../models/dish-category.enum";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.css']
})
export class DishComponent implements OnInit {

  dishes: Dish[] = [];

  model: DishViewModel = {
    name: '',
    category: undefined,
    description: '',
    calories: undefined,
    ingredients: []
  }

  constructor(private apiDishesService: ApiDishesService) {
  }

  ngOnInit(): void {
    this.getAllDishes();
  }


  public getAllDishes() {
    this.apiDishesService.getAllDishes().subscribe(
      response => {
        this.dishes = response;
      },
      error => {
        alert("An error occurred while getting all ingredients")
      }
    )
  }

  addIngredientToDish(name: string, units: string, calories: number) {
    console.log("NAME" + name)
    let ingredient = new Ingredient(name, units, calories);
    console.log("TERAZ" + ingredient.name);
    this.model.ingredients.push(ingredient);
  }

  addDish(): void {
    this.apiDishesService.addDish(this.model).subscribe(
      response => {
        location.reload();
      },
      error => {
        alert("An error has occured while sending feedback");
      }
    );

  }

}

export interface DishViewModel {
  name: string;
  category: DishCategory;
  description: string;
  calories: number;
  ingredients: Ingredient[];
}
