import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cidade} from '../model/cidade.model';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  apiUrl = 'http://localhost:8080/api/cidades';

  constructor(protected http: HttpClient) {
  }

  create(cidade: Cidade): Observable<any> {
    return this.http.post<any>(this.apiUrl, cidade, { observe: 'response' });
  }

  update(cidade: Cidade): Observable<any> {
    return this.http.put<any>(this.apiUrl, cidade, { observe: 'response' });
  }

  getAll(): Observable<any> {
    return this.http.get<Cidade[]>(this.apiUrl);
  }

  find(id: number): Observable<any> {
    return this.http.get<Cidade>(`${this.apiUrl}/${id}`);
  }

  remove(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
