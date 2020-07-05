import {Component, Inject, OnInit} from '@angular/core';
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishViewModel} from "../dish/dish.component";

@Component({
  selector: 'app-add-dish-window',
  templateUrl: './add-dish-window.component.html',
  styleUrls: ['./add-dish-window.component.css']
})
export class AddDishWindowComponent implements OnInit {

  dishViewModel: DishViewModel = {
    name: '',
    category: undefined,
    description: '',
    calories: undefined,
    ingredients: []
  }
  constructor(private apiDishesService: ApiDishesService) {
  }

  ngOnInit(): void {
  }

  receiveIngredients($event){
    this.dishViewModel.ingredients = $event;
  }

  saveDish(): void {
    this.apiDishesService.addDish(this.dishViewModel).subscribe(
      response => {
        location.reload();
      },
      error => {
        alert("An error has occured while sending feedback");
      }
    );
  }
}
