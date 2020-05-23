import { Pipe, PipeTransform } from '@angular/core';
import { City } from './interface/city';

@Pipe({
  name: 'filterCity'
})
export class FilterCityPipe implements PipeTransform {

  transform(items: City[], searchCityName: string): any {
    if (searchCityName === "") {
      return items;
    }
    const cities: City[] = [];
    searchCityName = searchCityName.toLowerCase() ;
    for (let i = 0; i < items.length; i++) {
      let cityName: string = items[i].cityName.toLowerCase();
      if (cityName.includes(searchCityName)) {
        cities.push(items[i])
      }
    }
    return cities;
  }
}
