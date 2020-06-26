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

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    IngredientComponent,
    NotFoundComponent,
    DishComponent,
    ImageUploaderComponent,
    ImageGetComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule
  ],
  providers: [ImageGetComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
