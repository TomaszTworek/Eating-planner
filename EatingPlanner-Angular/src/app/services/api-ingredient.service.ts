import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../models/ingredient";
import {IngredientViewModel} from "../components/ingredient/ingredient.component";

@Injectable({
  providedIn: 'root'
})
export class ApiIngredientService {
  private BASE_URL = "http://localhost:8080/ingredients";
  private ALL_INGREDIENTS_URL = `${this.BASE_URL}\\all`;
  private ADD_INGREDIENT_URL = `${this.BASE_URL}\\add`;

  constructor(private http: HttpClient) {

  }

  getAllIngredients(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.ALL_INGREDIENTS_URL);
  }

  addIngredient(ingredient: IngredientViewModel): Observable<any> {
    return this.http.post(this.ADD_INGREDIENT_URL, ingredient);
  }
}
