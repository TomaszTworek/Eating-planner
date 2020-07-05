import {Component, Inject, OnInit} from '@angular/core';
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishViewModel} from "../dish/dish.component";
import {ImageUploaderComponent} from "../image-uploader/image-uploader.component";
import {$e} from "codelyzer/angular/styles/chars";

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
    ingredients: [],
    image: null
  }

  constructor(private apiDishesService: ApiDishesService,
              private imageUploader: ImageUploaderComponent) {
  }

  ngOnInit(): void {
  }

  receiveIngredients($event) {
    this.dishViewModel.ingredients = $event;
  }

  receiveImage($event) {
    this.dishViewModel.image = $event;
  }

  saveDish(): void {
    console.log('WINDOW' + this.dishViewModel.image)
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
