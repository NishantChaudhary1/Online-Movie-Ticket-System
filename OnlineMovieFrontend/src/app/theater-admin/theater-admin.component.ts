import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Theater } from '../interface/theater';
import { TheaterWebService } from '../services/theater-web.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-theater-admin',
  templateUrl: './theater-admin.component.html',
  styleUrls: ['./theater-admin.component.css']
})
export class TheaterAdminComponent implements OnInit {

  constructor(private router: Router,private webService: TheaterWebService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.createForm() ;
    this.getData() ;
  }

  url: string = "theater" ;
  theatersList: Array<Theater>
  theater: Theater = undefined
  myForm: FormGroup ;

  createForm(){
    this.myForm = this.formBuilder.group({
      theaterName: new FormControl(this.theater ? this.theater.theaterName : '', Validators.required),
      theaterArea : new FormControl(this.theater ? this.theater.theaterArea : '', [Validators.required, Validators.minLength(4)])
    });
  }

  submitForm(data: FormGroup){
    if(data.valid){
      this.addTheater(data.value)
    }
  }

  addTheater(theater: Theater): void{
    if(this.theater)
      theater.theaterId = this.theater.theaterId
    this.webService.post(this.url+"/addTheater", theater).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.getData()
      this.myForm.reset()
      this.theater = undefined
    }, error => {
    })
  }

  getData(): void {
    this.webService.get(this.url + "/alltheaters").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.theatersList = response.data
    })
  }

  edit(theater: Theater): void {
    this.theater = theater
    this.myForm.controls['theaterName'].setValue(this.theater.theaterName)
    this.myForm.controls['theaterArea'].setValue(this.theater.theaterArea)
  }

  delete(theater: Theater): void {
    this.webService.delete(this.url+"/deletetheater/"+theater.theaterId, theater).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
  }

}
