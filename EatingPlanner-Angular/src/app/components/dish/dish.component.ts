import {Component, OnInit} from '@angular/core';
import {Ingredient} from "../../models/ingredient";
import {Dish} from "../../models/dish";
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishCategory} from "../../models/dish-category.enum";
import {ImageGetComponent} from "../image-get/image-get.component";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.css']
})
export class DishComponent implements OnInit {

  dishes: Dish[] = [];

  constructor(private apiDishesService: ApiDishesService, private imageGetComponent: ImageGetComponent) {
  }

  ngOnInit(): void {
    if(this.dishes != null) {
      this.getAllDishes();
    }
  }


  public getAllDishes() {
    this.apiDishesService.getAllDishes().subscribe(
      response => {
        this.dishes = response;
        for(let dish of this.dishes){
          this.imageGetComponent.getDishImageFromDB(dish);
        }
      },
      error => {
        alert("An error occurred while getting all ingredients")
      }
    )
  }
}

export interface DishViewModel {
  name: string;
  category: DishCategory;
  description: string;
  calories: number;
  ingredients: Ingredient[];
  image: File;
}
