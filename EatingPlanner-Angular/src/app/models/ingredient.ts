import {Dish} from "./dish";

export class Ingredient {
  id: number;
  name: string;
  units: string;
  calories: number;
  dishes : Dish;
}
