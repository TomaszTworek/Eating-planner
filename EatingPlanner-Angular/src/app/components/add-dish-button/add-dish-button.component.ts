import {Component, OnInit} from '@angular/core';
import {AddDishWindowComponent} from "../add-dish-window/add-dish-window.component";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
@Component({
  selector: 'app-add-dish-button',
  templateUrl: './add-dish-button.component.html',
  styleUrls: ['./add-dish-button.component.css']
})
export class AddDishButtonComponent implements OnInit {

  name: string

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  onCreateNewDish(): void {
    const dialogRef = this.dialog.open(AddDishWindowComponent,
      {width: '800px'});

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      dialogRef.close()
      this.refreshPage();
    });
  }

  private refreshPage(): void {
    window.location.reload();
  }
}
