import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ImageService} from "../../services/image.service";
import {Ingredient} from "../../models/ingredient";
import {Ng2ImgMaxService} from "ng2-img-max";

@Component({
  selector: 'app-image-uploader',
  templateUrl: './image-uploader.component.html',
  styleUrls: ['./image-uploader.component.css']
})
export class ImageUploaderComponent implements OnInit {

  image: File = null;
  private messageWhileUploadImage: string;

  constructor(private imageService: ImageService,
              private ng2ImgMax: Ng2ImgMaxService) {
  }

  ngOnInit(): void {
  }

  @Output() imageEvent = new EventEmitter<File>();

  //Gets called when the user selects an image
  public onFileChanged(event) {
    //Select File
    this.image = event.target.files[0];

    /*this.ng2ImgMax.resizeImage(image, 360, 250).subscribe(
      result => {
        this.image = new File([result], result.name);
      },
      error => {
        console.log('😢 Oh no!', error);
      }
    )*/
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

  public onUpload() {
    this.uploadImage('imageFile', this.image);
    this.imageEvent.emit(this.image);
  }
}
