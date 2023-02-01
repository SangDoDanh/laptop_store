import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductGroupDto} from '../dto/product-group-dto';
import {environment} from '../../environments/environment';
import {ProductGroupDetailDto} from '../dto/product-group-detail-dto';
import {ProductDto} from '../dto/product-dto';
import {SearchDto} from '../dto/search-dto';

@Injectable({
  providedIn: 'root'
})
export class ProductGroupService {
  dataSearchDto: SearchDto = {};
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<ProductGroupDto[]> {
    return this.httpClient.get<ProductGroupDto[]>(environment.API_URL + environment.PRODUCT_GROUPS);
  }

  getDetail(productGroupId: number): Observable<ProductGroupDetailDto> {
    return this.httpClient.get<ProductGroupDetailDto>(environment.API_URL + environment.PRODUCT_GROUP_DETAIL + productGroupId);
  }

  getProductById(id: number): Observable<ProductDto> {
    return this.httpClient.get<ProductDto>(environment.API_URL + environment.PRODUCT_GROUPS + '/' + id);
  }

  search(dataSearch: any): Observable<ProductGroupDto[]> {
    this.dataSearchDto.inchSearch = dataSearch.inchSearch;
    this.dataSearchDto.nameSearch = dataSearch.nameSearch;
    this.dataSearchDto.producer = dataSearch.producer;
    this.dataSearchDto.priceSearch = dataSearch.priceSearch.split(',');
    return this.httpClient.post<ProductGroupDto[]>(environment.API_URL + environment.PRODUCT_GROUPS_SEARCH, this.dataSearchDto);
  }
}
