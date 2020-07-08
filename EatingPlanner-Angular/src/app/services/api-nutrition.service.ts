import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Common} from "../models/api-ingredients";

@Injectable({
  providedIn: 'root'
})
export class ApiNutritionService {

  private GET_COMMON_INGREDIENT_BY_NAME = "http://localhost:8080/api/nutrition/getIngredient/";

  constructor(private http:HttpClient) { }

  getCommonIngredientsFromAPI(name: string): Observable<Common[]> {
    return this.http.get<Common[]>(this.GET_COMMON_INGREDIENT_BY_NAME + name);
  }
}
