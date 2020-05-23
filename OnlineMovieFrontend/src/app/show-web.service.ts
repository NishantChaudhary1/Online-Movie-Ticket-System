import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Show } from './interface/show';

@Injectable({
  providedIn: 'root'
})
export class ShowWebService {

  constructor(private httpClient: HttpClient) { }

  serverUrl: string = "http://localhost:9090/"
  url: string = "http://localhost:9090/show/movie"

  getShowsByMovieId(showId: number): Observable<any>{
    return this.httpClient.get(`${this.url}/${showId}`);
  }

  get(url: string): Observable<any>{
    return this.httpClient.get(this.serverUrl+url) ;
  }

  post(url: string, data: Show): Observable<any>{
    return this.httpClient.post(this.serverUrl+url, data) ;
  }

  put(url: string, data: Show): Observable<any> {
    return this.httpClient.put(this.serverUrl + url, data);
  }

  delete(url: string, data: Show): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.show_Id + "" } });
  }
}