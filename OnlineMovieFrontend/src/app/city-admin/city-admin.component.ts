import { Component, OnInit } from '@angular/core';
import { CityWebService } from '../services/city-web.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { City } from '../interface/city';
import { Router } from '@angular/router';

@Component({
  selector: 'app-city-admin',
  templateUrl: './city-admin.component.html',
  styleUrls: ['./city-admin.component.css']
})
export class CityAdminComponent implements OnInit {

  constructor(private router: Router, private webService: CityWebService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.createForm() ;
    this.getData() ;
  }

  url: string = "city" ;
  citiesList: Array<City>
  city: City = undefined
  myForm: FormGroup ;
  

  createForm(){
    this.myForm = this.formBuilder.group({
      cityName: new FormControl(this.city ? this.city.cityName : '', Validators.required),
      cityPincode : new FormControl(this.city ? this.city.cityPincode : '', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]),
      cityState : new FormControl(this.city ? this.city.cityState : '', [Validators.required])
    });
  }

  submitForm(data: FormGroup){
    if(data.valid){
      this.addMovie(data.value)
    }
  }

  addMovie(city: City): void{
    if(this.city)
      city.cityId = this.city.cityId
    this.webService.post(this.url+"/addCity", city).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.getData()
      this.myForm.reset()
      this.city = undefined
    }, error => {
    })
  }

  getData(): void {
    this.webService.get(this.url + "/allCity").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.citiesList = response.data
    })
  }

  edit(city: City): void {
    this.city = city
    this.myForm.controls['cityName'].setValue(this.city.cityName)
    this.myForm.controls['cityPincode'].setValue(this.city.cityPincode)
    this.myForm.controls['cityState'].setValue(this.city.cityState)
  }

  delete(city: City): void {
    this.webService.delete(this.url+"/delete/"+city.cityId, city).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
  }

}
