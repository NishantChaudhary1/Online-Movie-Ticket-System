import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theater } from '../interface/theater';
import { Show } from '../interface/show';

@Injectable({
  providedIn: 'root'
})
export class TheaterWebService {

  constructor(private httpClient: HttpClient) { }

  serverUrl: string = "http://localhost:9090/"
  private baseUrl1='http://localhost:9090/theater/';

  get(url: string): Observable<any>{
    return this.httpClient.get(this.serverUrl+url) ;
  }

  post(url: string, data: Theater): Observable<any>{
    return this.httpClient.post(this.serverUrl+url, data) ;
  }

  put(url: string, data: Theater): Observable<any> {
    return this.httpClient.put(this.serverUrl + url, data);
  }

  delete(url: string, data: Theater): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.theaterId + "" } });
  }

  createTheaterByCityId(cityId:number,theaterId: number, value1: any): Observable<any>
  {
    return this.httpClient.post(`${this.baseUrl1}/${cityId}/${theaterId}`,value1);
  }

}
