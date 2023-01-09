import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductGroupDto} from '../dto/product-group-dto';
import {environment} from '../../environments/environment';
import {ProductGroupDetailDto} from '../dto/product-group-detail-dto';

@Injectable({
  providedIn: 'root'
})
export class ProductGroupService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<ProductGroupDto[]> {
    return this.httpClient.get<ProductGroupDto[]>(environment.API_URL + environment.PRODUCT_GROUPS);
  }

  getDetail(productGroupId: number): Observable<ProductGroupDetailDto> {
    return this.httpClient.get<ProductGroupDetailDto>(environment.API_URL + environment.PRODUCT_GROUP_DETAIL + productGroupId);
  }
}
