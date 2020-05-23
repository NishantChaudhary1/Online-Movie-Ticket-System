import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ShowWebService } from '../show-web.service';
import { Show } from '../interface/show';
import { Movie } from '../interface/movie';
import { WebService } from '../services/web.service';

@Component({
  selector: 'app-show-view',
  templateUrl: './show-view.component.html',
  styleUrls: ['./show-view.component.css']
})
export class ShowViewComponent implements OnInit {

  movieId: number
  shows: Array<Show>
  show: Show
  movie: Movie
  errorMsg: string

  constructor(private router: Router, private route: ActivatedRoute, 
              private webService: ShowWebService, private movieWebService: WebService) { }

  ngOnInit(): void {
    this.getMovie() ;
    this.route.paramMap.subscribe(
      () => {
        this.reloadData() ;
      }
    )
  }

  reloadData() {
    this.movieId= +this.route.snapshot.params['id'];
    this.webService.getShowsByMovieId(this.movieId).subscribe(
      res=> {
        this.shows = res ;
      }
    )
  }

  getMovie(): void{
    this.movieId= +this.route.snapshot.params['id'];
    console.log(this.movieId)
    this.movieWebService.getMovieById(this.movieId).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.movie = response.data
    }, error => {
      this.errorMsg = error, JSON.stringify(this.errorMsg)
    })
  }

}
