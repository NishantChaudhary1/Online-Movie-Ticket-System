import { Component, OnInit } from '@angular/core';
import { Theater } from '../interface/theater';
import { Router } from '@angular/router';
import { TheaterWebService } from '../services/theater-web.service';

@Component({
  selector: 'app-search-theater',
  templateUrl: './search-theater.component.html',
  styleUrls: ['./search-theater.component.css']
})
export class SearchTheaterComponent implements OnInit {

  constructor(private router: Router, private webService: TheaterWebService) { }

  ngOnInit(): void {
    this.getData() ;
  }

  url: string = "theater" ;
  theatersList: Array<Theater> ;
  theater: Theater = undefined ;
  searchText: string ;

  getData(): void {
    this.webService.get(this.url + "/alltheaters").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.theatersList = response.data
    })
  }


  forwardToBooking(){
    this.router.navigate(['./movie/city/'], {
    })
  }
}
