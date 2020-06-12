import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

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

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  addIngredient(): void {
    let url = "http://localhost:8080/ingredients/add";
    this.http.post(url, this.model).subscribe(
      result => {
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
