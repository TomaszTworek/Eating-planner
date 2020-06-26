import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Image} from "../models/image";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private UPLOAD_IMAGE_URL = "http://localhost:8080/image/upload";
  private GET_IMAGE_BY_NAME_URL = "http://localhost:8080/image/get/";
  private GET_ALL_IMAGES = "http://localhost:8080/image/get/all"

  constructor(private http:HttpClient) { }

  uploadImage(uploadImageData: FormData): Observable<any> {
    return this.http.post(this.UPLOAD_IMAGE_URL, uploadImageData, {observe: 'response'});
  }
  getImageByName(imageName: string): Observable<Image> {
    return this.http.get<Image>(this.GET_IMAGE_BY_NAME_URL + imageName);
  }

  getAllImages(): Observable<Image[]>{
    return this.http.get<Image[]>(this.GET_ALL_IMAGES);
  }
}
