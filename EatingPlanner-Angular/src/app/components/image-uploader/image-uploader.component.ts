import { Component, OnInit } from '@angular/core';
import {ImageService} from "../../services/image.service";

@Component({
  selector: 'app-image-uploader',
  templateUrl: './image-uploader.component.html',
  styleUrls: ['./image-uploader.component.css']
})
export class ImageUploaderComponent implements OnInit {

  image: File = null;
  private messageWhileUploadImage: string;

  constructor(private imageService:ImageService) { }

  ngOnInit(): void {
  }

  //Gets called when the user selects an image
  public onFileChanged(event) {
    //Select File
    this.image = event.target.files[0];
  }


  private prepareFormData(name: string, image: File) {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', image, image.name);
    return uploadImageData;
  }

 private uploadImage(imageFile: string, image: File) {
    const uploadImageData = this.prepareFormData(imageFile, image);
    //Make a call to the Spring Boot Application to save the image
    this.imageService.uploadImage(uploadImageData)
      .subscribe((response) => {
          if (response.status === 200) {
            this.messageWhileUploadImage = 'Image uploaded successfully';
          } else {
            this.messageWhileUploadImage = 'Image not uploaded successfully';
          }
        }
      );
    return uploadImageData;
  }

  onUpload() {
    this.uploadImage('imageFile', this.image);
  }
}
