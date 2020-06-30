import {Component, Inject, OnInit} from '@angular/core';
import {AddDishButtonComponent} from "../add-dish-button/add-dish-button.component";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-add-dish-window',
  templateUrl: './add-dish-window.component.html',
  styleUrls: ['./add-dish-window.component.css']
})
export class AddDishWindowComponent implements OnInit {

 /* constructor(public dialogRef: MatDialogRef<AddDishWindowComponent>) {
  }*/

  ngOnInit(): void {
  }

  /*onNoClick(): void {
    this.dialogRef.close();
  }*/


}
