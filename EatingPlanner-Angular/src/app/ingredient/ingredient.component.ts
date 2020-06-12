import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.css']
})
export class IngredientComponent implements OnInit {
  model: IngredientViewModel = {
    name: '',
    units: '',
    calories: 0
  }

  constructor() {
  }

  ngOnInit(): void {
  }

  addIngredient(): void {
    alert(this.model.name);
  }

}

export interface IngredientViewModel {
  name: string;
  units: string;
  calories: number;
}
