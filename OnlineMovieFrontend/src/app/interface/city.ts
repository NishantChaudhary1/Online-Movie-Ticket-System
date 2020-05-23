import { Theater } from './theater';

export interface City{
    cityId: number,
    cityName: string,
    cityPincode: string,
    cityState: string,
    cityTheaters: Array<Theater>
}