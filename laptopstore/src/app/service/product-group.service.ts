import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductGroupDto} from '../dto/product-group-dto';
import {environment} from '../../environments/environment';
import {ProductGroupDetailDto} from '../dto/product-group-detail-dto';
import {ProductDto} from '../dto/product-dto';
import {SearchDto} from '../dto/search-dto';
import {PageProductGroupDto} from '../dto/page-product-group-dto';
import {ProductDetailList} from '../dto/product-detail-list';
import {ProductCartDto} from '../dto/product-cart-dto';

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

  getAllAndSearchPage(dataSearch: any, pageNumber: number): Observable<PageProductGroupDto> {
    this.dataSearchDto.inchSearch = dataSearch.inchSearch;
    this.dataSearchDto.nameSearch = dataSearch.nameSearch;
    this.dataSearchDto.producer = dataSearch.producer;
    this.dataSearchDto.priceSearch = dataSearch.priceSearch.split(',');
    return this.httpClient.post(environment.API_URL + environment.PRODUCT_GROUPS_SEARCH_AND_PAGE + '?page=' + pageNumber,
      this.dataSearchDto);
  }

  getAllProductDetailByProductgroupId(id: any): Observable<ProductDetailList[]> {
    return this.httpClient.get<ProductDetailList[]>(environment.API_URL + environment.PRODUCT_DETAIL_LIST + '/' + id);
  }

  addToCart(idAccount: string, idProduct: string): Observable<any> {
    return this.httpClient.post<any>(environment.API_URL + environment.ADD_TO_CART
      + '?idAccount=' + idAccount
      + '&idProduct=' + idProduct,  {});
  }

  getAllProductListpay(id: string): Observable<ProductCartDto[]> {
    return this.httpClient.get<ProductCartDto[]>(environment.API_URL + environment.HISTORY_PAY + '/' + id);
  }
}
