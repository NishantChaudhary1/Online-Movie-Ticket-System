import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from '../interface/city';

@Injectable({
  providedIn: 'root'
})
export class CityWebService {

  constructor(private httpClient: HttpClient) { }

  serverUrl: string = "http://localhost:9090/"

  get(url: string): Observable<any>{
    return this.httpClient.get(this.serverUrl+url) ;
  }

  post(url: string, data: City): Observable<any>{
    return this.httpClient.post(this.serverUrl+url, data) ;
  }

  put(url: string, data: City): Observable<any> {
    return this.httpClient.put(this.serverUrl + url, data);
  }

  delete(url: string, data: City): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.cityId + "" } });
  }
}
