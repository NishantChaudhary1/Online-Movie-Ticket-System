import { Component, OnInit } from '@angular/core';
import { WebService } from '../services/web.service';
import { Movie } from '../interface/movie';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-view',
  templateUrl: './movie-view.component.html',
  styleUrls: ['./movie-view.component.css']
})
export class MovieViewComponent implements OnInit {

  constructor(private webService: WebService, private router: Router) { }

  ngOnInit(): void {
    this.getData() ;
  }

  url: string = "movie" ;
  moviesList: Array<Movie> ;
  movie: Movie = undefined ;
  errorMsg: string

  getData(): void {
    this.webService.get(this.url + "/allMovies").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.moviesList = response.data
    }, error => {
      this.errorMsg = error, JSON.stringify(this.errorMsg)
    })
  }

  onSelect(movie: Movie){
    this.router.navigate(['user/movie/show', movie.movieId])
  }
}
