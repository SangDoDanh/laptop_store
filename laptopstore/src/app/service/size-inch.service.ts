import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {SizeInchDto} from '../dto/size-inch-dto';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SizeInchService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<SizeInchDto[]> {
    return this.httpClient.get<SizeInchDto[]>(environment.API_URL + environment.SIZE_INCH);
  }
}
