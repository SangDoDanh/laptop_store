import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProducerService {

  constructor(private httpClient: HttpClient) { }

  getAllForLap(): Observable<any> {
    return this.httpClient.get<any>(environment.API_URL + environment.API_URL_PRODUCER_FOR_LAP);
  }
}
