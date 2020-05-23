import { Pipe, PipeTransform } from '@angular/core';
import { Theater } from './interface/theater';

@Pipe({
  name: 'filterTheater'
})
export class FilterTheaterPipe implements PipeTransform {

  transform(items: Theater[], searchText: string): any {
    if (searchText === "") {
      return items;
    }
    const theaters: Theater[] = [];
    searchText = searchText.toLowerCase() ;
    for (let i = 0; i < items.length; i++) {
      let theaterName: string = items[i].theaterName.toLowerCase();
      if (theaterName.includes(searchText)) {
        theaters.push(items[i])
      }
    }
    return theaters;
  }
}


