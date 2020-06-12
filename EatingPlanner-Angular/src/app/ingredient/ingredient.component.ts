import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ingredient} from "../models/ingredient";

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.css']
})
export class IngredientComponent implements OnInit {
  ingredients: Ingredient[] = [];

  model: IngredientViewModel = {
    name: '',
    units: '',
    calories: undefined
  }

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.getAllIngredients();
  }

  public getAllIngredients() {
    let url = "http://localhost:8080/ingredients/all"
    this.http.get<Ingredient[]>(url).subscribe(
      response => {
        this.ingredients = response;
      },
      error => {
        alert("An error occurred while getting all ingredients")
      }
    )
  }

  addIngredient(): void {
    let url = "http://localhost:8080/ingredients/add";
    this.http.post(url, this.model).subscribe(
      response => {
        location.reload();
      },
      error => {
        alert("An error has occured while sending feedback");
      }
    );

  }

}

export interface IngredientViewModel {
  name: string;
  units: string;
  calories: number;
}
