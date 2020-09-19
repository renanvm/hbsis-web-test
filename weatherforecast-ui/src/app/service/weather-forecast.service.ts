import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Cidade} from '../model/cidade.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherForecastService {

  apiUrl = 'http://localhost:8080/api/weather';

  constructor(protected http: HttpClient) { }

  checkCidadeIsValid(cidade: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${cidade}`);
  }

}
