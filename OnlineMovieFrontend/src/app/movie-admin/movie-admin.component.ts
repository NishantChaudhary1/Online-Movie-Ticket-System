import { Component, OnInit } from '@angular/core';
import { WebService } from '../services/web.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Movie } from '../interface/movie';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-admin',
  templateUrl: './movie-admin.component.html',
  styleUrls: ['./movie-admin.component.css']
})
export class MovieAdminComponent implements OnInit {

  constructor(private route: Router, private webService: WebService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.createForm() ;
    this.getData() ;
  }

  url: string = "movie" ;
  moviesList: Array<Movie>
  movie: Movie = undefined
  myForm: FormGroup ;
  errorMsg : string 
  reg = '(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?'

  createForm(){
    this.myForm = this.formBuilder.group({
      movieName: new FormControl(this.movie ? this.movie.movieName : '', Validators.required),
      movieDirector : new FormControl(this.movie ? this.movie.movieDirector : '', [Validators.required, Validators.minLength(2)]),
      movieDescription : new FormControl(this.movie ? this.movie.movieDescription : '', [Validators.required, Validators.minLength(10)]),
      movieImg : new FormControl(this.movie ? this.movie.movieImg : '', [Validators.required, Validators.pattern(this.reg)])
    });
  }

  submitForm(data: FormGroup){
    if(data.valid){
      this.addMovie(data.value)
    }
  }

  addMovie(movie: Movie): void{
    if(this.movie)
      movie.movieId = this.movie.movieId
    this.webService.post(this.url+"/addMovie", movie).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.getData()
      this.myForm.reset()
      this.movie = undefined
    }, error => {
      this.errorMsg = error, JSON.stringify(this.errorMsg)
    })
  }

  getData(): void {
    this.webService.get(this.url + "/allMovies").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.moviesList = response.data
    },error => {
      this.errorMsg = error, JSON.stringify(this.errorMsg)
    })
  }

  edit(movie: Movie): void {
    this.movie = movie
    this.myForm.controls['movieName'].setValue(this.movie.movieName)
    this.myForm.controls['movieDirector'].setValue(this.movie.movieDirector)
    this.myForm.controls['movieDescription'].setValue(this.movie.movieDescription)
    this.myForm.controls['movieImg'].setValue(this.movie.movieImg)
  }

  delete(movie: Movie): void {
    this.webService.delete(this.url+"/delete/"+movie.movieId, movie).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
      this.errorMsg = error, JSON.stringify(this.errorMsg)
    })
  }
}
