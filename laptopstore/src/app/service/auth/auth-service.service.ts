import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private httpClient: HttpClient) { }

  signIn(rfLogin: any): Observable<any> {
    return  this.httpClient.post<any>(environment.API_URL + environment.AUTH_LOGIN, rfLogin);
  }
}
