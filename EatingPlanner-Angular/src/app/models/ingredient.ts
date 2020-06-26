import {Dish} from "./dish";

export class Ingredient {
  id: number;
  name: string;
  units: string;
  calories: number;
  dishes: Dish[];

  constructor(name: string, units: string, calories: number) {
    this.name = name;
    this.units = units;
    this.calories = calories;
  }
}
