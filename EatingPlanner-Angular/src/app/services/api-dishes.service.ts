import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../models/ingredient";
import {IngredientViewModel} from "../components/ingredient/ingredient.component";
import {Dish} from "../models/dish";
import {DishViewModel} from "../components/dish/dish.component";

@Injectable({
  providedIn: 'root'
})
export class ApiDishesService {
  private BASE_URL = "http://localhost:8080/dishes";
  private ALL_DISHES_URL = `${this.BASE_URL}\\all`;
  private ADD_DISH_URL = `${this.BASE_URL}\\add`;

  constructor(private http: HttpClient) { }

  getAllDishes(): Observable<Dish[]> {
    return this.http.get<Dish[]>(this.ALL_DISHES_URL);
  }

  addDish(dish: DishViewModel): Observable<any> {
    return this.http.post(this.ADD_DISH_URL, dish);
  }
}
