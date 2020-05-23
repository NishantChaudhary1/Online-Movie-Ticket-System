import { City } from './city';
import { Show } from './show';

// export interface Theater {
//     theaterId: number,
//     theaterName: string,
//     theaterArea: string
//     theaterCity: City,
//     theaterShows: Array<Show>,
//     cityId: number
// }

export class Theater {
    theaterId: number;
    theaterName: string;
    theaterArea: string ;
    theaterCity: City;
    theaterShows: Array<Show>;
    cityId: number;
}
