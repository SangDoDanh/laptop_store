import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductCartDto} from '../dto/product-cart-dto';
import {environment} from '../../environments/environment';
import {ShipDto} from '../dto/ship-dto';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  quality: number;

  constructor(private httpClient: HttpClient) { }

  getAllProductCartByUserId(id: string): Observable<ProductCartDto[]> {
    return this.httpClient.get<ProductCartDto[]>(environment.API_URL + environment.PRODUCT_CART_BY_USER + '/' + id);
  }

  updateQuality(ordersId: string, quality: number): Observable<any> {
    return this.httpClient.post(environment.API_URL + environment.CART_UPDATE_QUALITY
      + '?ordersId=' + ordersId
      + '&quality=' + quality,
      {});
  }

  payOrderDetail(orderDetailList: any) {
    return this.httpClient.put(environment.API_URL + environment.PAY_ORDERDETAIL, orderDetailList);
  }

  updateRemoveStatus(idDelete: string): Observable<any> {
    return this.httpClient.put<any>(environment.API_URL + environment.UPDATE_REMOVE_STATUS + '/' + idDelete, {})
  }

  getAllShip(): Observable<ShipDto[]> {
    return this.httpClient.get<ShipDto[]>(environment.API_URL + environment.SHIP);
  }
}
