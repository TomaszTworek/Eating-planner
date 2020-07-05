import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {IngredientComponent} from './components/ingredient/ingredient.component';
//Import forms:
import {FormsModule} from "@angular/forms";
//Import http to connect with backend
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NavigationComponent} from "./components/navigation/navigation.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import { DishComponent } from './components/dish/dish.component';
import { ImageUploaderComponent } from './components/image-uploader/image-uploader.component';
import { ImageGetComponent } from './components/image-get/image-get.component';
import {MatButtonModule} from "@angular/material/button";
import { AddDishButtonComponent } from './components/add-dish-button/add-dish-button.component';
import { AddDishWindowComponent } from './components/add-dish-window/add-dish-window.component';
import {MaterialModule} from "./components/angular-material/material.module";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogModule} from '@angular/material/dialog';
import {AddIngredientToDishComponent} from "./components/ingredient/add-ingredient-to-dish/add-ingredient-to-dish.component";


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    IngredientComponent,
    NotFoundComponent,
    DishComponent,
    ImageUploaderComponent,
    ImageGetComponent,
    AddDishButtonComponent,
    AddDishWindowComponent,
    AddIngredientToDishComponent
  ],
  entryComponents: [AddDishButtonComponent, AddDishWindowComponent],
  imports: [
    BrowserModule,
    FormsModule,
    MaterialModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule
  ],
  providers: [ImageGetComponent,ImageUploaderComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
