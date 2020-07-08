import {Component, Inject, OnInit} from '@angular/core';
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishViewModel} from "../dish/dish.component";
import {ImageUploaderComponent} from "../image-uploader/image-uploader.component";
import {$e} from "codelyzer/angular/styles/chars";
import {ApiNutritionService} from "../../services/api-nutrition.service";
import {Common} from "../../models/api-ingredients";
import {Ingredient} from "../../models/ingredient";

@Component({
  selector: 'app-add-dish-window',
  templateUrl: './add-dish-window.component.html',
  styleUrls: ['./add-dish-window.component.css']
})
export class AddDishWindowComponent implements OnInit {

  commons: Common[] = [];
  displayedColumns: string[] = ['photo', 'food_name', 'serving_unit', 'plus'];
  isVisible: boolean = false;
  ingredients: Ingredient[] = [];

  dishViewModel: DishViewModel = {
    name: '',
    category: undefined,
    description: '',
    calories: undefined,
    ingredients: [],
    image: null
  }

  constructor(private apiDishesService: ApiDishesService,
              private imageUploader: ImageUploaderComponent,
              private apiNutritionService: ApiNutritionService) {
  }

  ngOnInit(): void {
  }

 /* receiveIngredients($event) {
    this.dishViewModel.ingredients = $event;
  }*/

  receiveImage($event) {
    this.dishViewModel.image = $event;
  }

  saveDish(): void {
    console.log('WINDOW' + this.dishViewModel.image)
    this.dishViewModel.ingredients = this.ingredients;
    this.apiDishesService.addDish(this.dishViewModel).subscribe(
      response => {
        location.reload();
      },
      error => {
        alert("An error has occured while sending feedback");
      }
    );
  }

  getIngredients(name: string) {
    this.apiNutritionService.getCommonIngredientsFromAPI(name).subscribe(
      res => {
        this.commons = res;
      },
      err => {
        console.log("Something goes wrong, while getting ingredients");
      })
  }

  addIngredient(ingredientName: string, calories: number, units: string) {
    let newIngredient: Ingredient = {
      id: null,
      name: ingredientName,
      units: units,
      calories: calories,
      dishes: null
    }
    console.log('New Ingredient name: ', newIngredient.name);
    console.log('New Ingredient amount: ', newIngredient.calories);
    console.log('New Ingredient units: ', newIngredient.units);
    this.ingredients.push(newIngredient);
    this.displayMessageForUser();
  }

  displayMessageForUser(): void {
    if (this.isVisible) {
      return;
    }
    this.isVisible = true;
    setTimeout(() => this.isVisible = false, 1500)
  }
}
