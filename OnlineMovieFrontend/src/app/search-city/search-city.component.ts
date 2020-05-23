import { Component, OnInit } from '@angular/core';
import { CityWebService } from '../services/city-web.service';
import { City } from '../interface/city';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-city',
  templateUrl: './search-city.component.html',
  styleUrls: ['./search-city.component.css']
})
export class SearchCityComponent implements OnInit {

  constructor(private webService: CityWebService, private router: Router) { }

  ngOnInit(): void {
    this.getData() ;
  }

  url: string = "city" ;
  citiesList: Array<City> ;
  city: City = undefined ;
  searchText: string ;

  getData(): void {
    this.webService.get(this.url + "/allCity").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.citiesList = response.data
    })
  }


  forwardToBooking(){
    this.router.navigate(['./movie/city/'], {
    })
  }
}
