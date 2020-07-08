export interface ApiIngredients {
  common: Common[];
  branded: Branded[];
}

export interface Common {
  food_name: string;
  serving_unit: string;
  tag_name: string;
  serving_qty: number;
  commonType: number;
  tag_id: string;
  photo: Photo;
  locale: string;
}

export interface Branded {
  food_name: string;
  serving_unit: string;
  nixBrandId: string;
  brandNameItemName: string;
  serving_qty: number;
  nfCalories: number;
  photo: PhotoBranded;
  brandName: string;
  region: number;
  brandType: number;
  nixItemId: string;
  locale: string;
}

export interface Photo {
  thumb: string;
  highres: object;
  isUerUploaded: boolean;
}

export interface PhotoBranded {
  thumb: string;
  highres: object;
  isUerUploaded: boolean;
}
