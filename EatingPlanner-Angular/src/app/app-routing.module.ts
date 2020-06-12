import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IngredientComponent} from "./ingredient/ingredient.component";
import {NotFoundComponent} from "./not-found/not-found.component";

const routes: Routes = [
  {
    path: 'ingredients',
    component: IngredientComponent
  },
  {
    path:'',
    component: IngredientComponent,
  },
  {
    path:'**',
    component:NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:true})],
  exports: [RouterModule]
})

export class AppRoutingModule { }
