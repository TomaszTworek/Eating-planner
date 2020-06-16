import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IngredientComponent} from "./components/ingredient/ingredient.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {DishComponent} from "./components/dish/dish.component";

const routes: Routes = [
  {
    path: 'ingredients',
    component: IngredientComponent
  },
  {
    path: 'dishes',
    component: DishComponent
  },
  {
    path: '',
    component: IngredientComponent,
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: true})],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
