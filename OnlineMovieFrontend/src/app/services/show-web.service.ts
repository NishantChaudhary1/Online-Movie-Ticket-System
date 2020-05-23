import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShowWebService {

  constructor(private httpClient: HttpClient) { }

  serverUrl: string = "http://localhost:9090/"

  get(url: string): Observable<any>{
    return this.httpClient.get(this.serverUrl+url) ;
  }
}
