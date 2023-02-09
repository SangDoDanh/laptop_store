import { Component, OnInit } from '@angular/core';
import {ProductCartDto} from '../dto/product-cart-dto';
import {ProductGroupService} from '../service/product-group.service';
import {TokenServiceService} from '../service/auth/token-service.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  productCartDtos: ProductCartDto[];
  constructor(private productService: ProductGroupService,
              private tokenService: TokenServiceService) { }

  ngOnInit(): void {
    this.productService.getAllProductListpay(this.tokenService.getId()).subscribe(data => {
      data.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      this.productCartDtos = data;
    });
  }

}
