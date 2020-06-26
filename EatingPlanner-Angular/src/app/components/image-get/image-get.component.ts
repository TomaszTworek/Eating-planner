import { Component, OnInit } from '@angular/core';
import {Dish} from "../../models/dish";
import {ImageService} from "../../services/image.service";

@Component({
  selector: 'app-image-get',
  templateUrl: './image-get.component.html',
  styleUrls: ['./image-get.component.css']
})
export class ImageGetComponent implements OnInit {

  base64Data: any;
  retrieveResponse: any;

  constructor(private imageService: ImageService) {
  }

  ngOnInit(): void {
  }

  getDishImageFromDB(dish: Dish) {
    this.imageService.getImageByName(dish.image.name)
      .subscribe(
        res => {
          this.retrieveResponse = res;
          this.base64Data = this.retrieveResponse.picByte;
          console.log(this.base64Data);
          dish.getImg = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }


}
