import {Ingredient} from "./ingredient";
import {DishCategory} from "./dish-category.enum";

export interface Dish {
  id: number;
  name: string;
  category: DishCategory;
  description: string;
  ingredients: Ingredient[];
  image : File;
  getImg: any;
  calories: number;
}
