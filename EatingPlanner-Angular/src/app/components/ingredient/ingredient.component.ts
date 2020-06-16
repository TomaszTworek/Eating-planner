import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ingredient} from "../../models/ingredient";
import {ApiIngredientService} from "../../services/api-ingredient.service";

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

  constructor(private apiIngredientService: ApiIngredientService) {
  }

  ngOnInit(): void {
    this.getAllIngredients();
  }

  public getAllIngredients() {
    this.apiIngredientService.getAllIngredients().subscribe(
      response => {
        this.ingredients = response;
      },
      error => {
        alert("An error occurred while getting all ingredients")
      }
    )
  }

  addIngredient(): void {
    this.apiIngredientService.addIngredient(this.model).subscribe(
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
