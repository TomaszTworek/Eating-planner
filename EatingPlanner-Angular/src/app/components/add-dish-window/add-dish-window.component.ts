import {Component, OnInit} from '@angular/core';
import {ApiDishesService} from "../../services/api-dishes.service";
import {DishViewModel} from "../dish/dish.component";
import {ImageUploaderComponent} from "../image-uploader/image-uploader.component";
import {ApiNutritionService} from "../../services/api-nutrition.service";
import {Common} from "../../models/api-ingredients";
import {Ingredient} from "../../models/ingredient";
import {ConfirmDialogComponent, ConfirmDialogModel} from "../confirm-dialog/confirm-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatTable, MatTableDataSource} from "@angular/material/table";
import {ViewChild} from "@angular/core";

@Component({
  selector: 'app-add-dish-window',
  templateUrl: './add-dish-window.component.html',
  styleUrls: ['./add-dish-window.component.css']
})
export class AddDishWindowComponent implements OnInit {

  commons: Common[] = [];
  displayedColumnsAPIIngredients: string[] = ['photo', 'food_name', 'serving_unit', 'plus'];
  displayedColumnsAddedIngredients: string[] = ['index', 'ing_name', 'units','deleteIngredient']
  public isVisible: boolean = false;
  ingredients: Ingredient[] = [];
  result: string = '';
  indexCounter: number = 0;
  @ViewChild(MatTable) table: MatTable<Ingredient>;

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required),
  })
  dishViewModel: DishViewModel = {
    name: '',
    category: undefined,
    description: '',
    calories: undefined,
    ingredients: [],
    image: null
  }

  constructor(private apiDishesService: ApiDishesService,
              private imageUploader: ImageUploaderComponent,
              private apiNutritionService: ApiNutritionService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  receiveImage($event) {
    this.dishViewModel.image = $event;
  }

  saveDish(): void {
    console.log('WINDOW' + this.dishViewModel.image)
    this.dishViewModel.ingredients = this.ingredients;
    this.apiDishesService.addDish(this.dishViewModel).subscribe(
      response => {
        location.reload();
      },
      error => {
        alert("An error has occured while sending feedback");
      }
    );
    this.indexCounter = 0;
  }

  getIngredients(name: string) {
    this.apiNutritionService.getCommonIngredientsFromAPI(name).subscribe(
      res => {
        this.commons = res;
      },
      err => {
        console.log("Something goes wrong, while getting ingredients");
      })
  }

  addIngredient(ingredientName: string, calories: number, units: string) {
    let newIngredient: Ingredient = {
      id: null,
      name: ingredientName,
      units: units,
      calories: calories,
      dishes: null,
    }
    this.indexCounter++;
    this.ingredients.push(newIngredient);
    this.displayMessageForUser();
    this.table.renderRows();
  }

  displayMessageForUser(): void {
    if (this.isVisible) {
      return;
    }
    this.isVisible = true;
    setTimeout(() => this.isVisible = false, 1500)
  }

  confirmDialog(): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel("Confirm Action", message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  }

  deleteIngredient(ingredientIndex: number): void {
    if (ingredientIndex !== -1) {
      this.ingredients.splice(ingredientIndex, 1);
      this.table.renderRows();

    }
  }
}
