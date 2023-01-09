import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {TokenService} from "./token.service";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  token: String;
  httpOptions: any;

  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenService
  ) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.tokenService.getToken()}`
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200/',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  getCustomerList(): Observable<any> {
    return this.httpClient.get<any>(environment.URL_API + '/user/test2', this.httpOptions);
  }

}
