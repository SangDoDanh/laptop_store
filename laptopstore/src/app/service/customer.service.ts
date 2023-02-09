import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerDto} from '../dto/customer-dto';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  getCustomerByUSerId(idAccount: string): Observable<CustomerDto> {
   return this. httpClient.get<CustomerDto>(environment.API_URL + environment.CUSTOMER + '/' + idAccount);
  }
}
