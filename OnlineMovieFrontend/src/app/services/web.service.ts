import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { Movie } from '../interface/movie';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class WebService {

  constructor(private httpClient: HttpClient) { }

  serverUrl: string = "http://localhost:9090/"
  url: string = "http://localhost:9090/movie"

  get(url: string): Observable<any>{
    return this.httpClient.get(this.serverUrl+url)
    .pipe(catchError(this.handleError)) ;
  }

  post(url: string, data: Movie): Observable<any>{
    return this.httpClient.post(this.serverUrl+url, data)
    .pipe(catchError(this.handleError)) ;
  }

  put(url: string, data: Movie): Observable<any> {
    return this.httpClient.put(this.serverUrl + url, data)
    .pipe(catchError(this.handleError)) ;
  }

  delete(url: string, data: Movie): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.movieId + "" } })
    .pipe(catchError(this.handleError)) ;
  }

  getMovieById(movieId: number): Observable<any>{
    return this.httpClient.get(`${this.url}/${movieId}`)
    .pipe(catchError(this.handleError));
  }

  private handleError(error : HttpErrorResponse){
    return throwError(error.error || "Server error") ;
  }
}
