import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShowWebService } from '../show-web.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Show } from '../interface/show';

@Component({
  selector: 'app-show-admin',
  templateUrl: './show-admin.component.html',
  styleUrls: ['./show-admin.component.css']
})
export class ShowAdminComponent implements OnInit {

  constructor(private route: Router, private webService: ShowWebService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.createForm() ;
  }

  url: string = "show" ;
  showsList: Array<Show>
  show: Show = undefined
  myForm: FormGroup ;
  theaterId: number ;
  movieId: number

  createForm(){
    this.myForm = this.formBuilder.group({
      theaterId: new FormControl(this.theaterId ? this.theaterId : '', Validators.required),
      movieId : new FormControl(this.movieId ? this.movieId : '', [Validators.required, Validators.minLength(2)]),
      show_time : new FormControl(this.show ? this.show.show_time : '', [Validators.required, Validators.maxLength(10)])
    });
  }

  submitForm(data: FormGroup){
    if(data.valid){
      this.theaterId = data.value.theaterId ;
      this.movieId = data.value.movieId ;
      this.addShow(data.value)
    }
  }

  addShow(show: Show): void{
    if(this.show)
      show.show_Id = this.show.show_Id
    this.webService.post(this.url+"/"+this.theaterId+"/"+this.movieId, show).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.getData()
      this.myForm.reset()
      this.show = undefined
    }, error => {
    })
  }

  getData(): void {
    console.log(this.movieId)
    this.webService.get(this.url + "/movie/"+this.movieId).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.showsList = res
    })
  }

  edit(show: Show): void {
    this.show = show
    this.myForm.controls['theaterId'].setValue(this.theaterId)
    this.myForm.controls['movieId'].setValue(this.movieId)
    this.myForm.controls['show_time'].setValue(this.show.show_time)
  }

  delete(show: Show): void {
    this.webService.delete(this.url+"/delete/"+show.show_Id, show).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
  }

}
