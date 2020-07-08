import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {DishComponent} from "./components/dish/dish.component";

const routes: Routes = [
  {
    path: 'dishes',
    component: DishComponent
  },
  {
    path: '',
    component: DishComponent,
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
