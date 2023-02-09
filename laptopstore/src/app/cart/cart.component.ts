import { Component, OnInit } from '@angular/core';
import {TokenServiceService} from '../service/auth/token-service.service';
import {CartService} from '../service/cart.service';
import {ProductCartDto} from '../dto/product-cart-dto';
import {render} from 'creditcardpayments/creditCardPayments';
import {style} from '@angular/animations';
import {ShipDto} from '../dto/ship-dto';
import {CustomerService} from '../service/customer.service';
import {CustomerDto} from '../dto/customer-dto';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  customer: CustomerDto;
  productCartDtos: ProductCartDto[];
  productCartPay: ProductCartDto[] = [];
  shipSelected: ShipDto;
  id: any;
  indexProductPay = -1;
  total = 0;
  totalVnd = 0;
  idDelete: string;
  productCartDelete: ProductCartDto;
  orderDetailList: string[] = [];
  shipDtos: ShipDto[];
  feeShip = 0;
  locationShip: string;
  constructor(private tokenService: TokenServiceService,
              private cartService: CartService,
              private customerService: CustomerService,
              private toastService: ToastrService,
              private titleService: Title) {
    render(
      {
        id: '#myPaypalButtons',
        currency: 'USD',
        value: '100.00',
        onApprove: details => {
          console.log('thanh toan thanh cong');
        }
      }
    );
  }

  ngOnInit(): void {
    this.titleService.setTitle('Moki Tech | Giỏ hàng');
    this.customerService.getCustomerByUSerId(this.tokenService.getId()).subscribe(data => {
      this.customer = data;
      console.log('customer: ', data);
      this.locationShip = data.address_detail;
      this.cartService.getAllProductCartByUserId(this.tokenService.getId()).subscribe(productCartDtoList => {
        productCartDtoList.forEach(value => {
          value.urlImgs = value.urlImgs.split(',')[0];
          value.locationShip = this.locationShip;
        });
        this.productCartDtos = productCartDtoList;
        console.log(productCartDtoList);
        this.cartService.quality = productCartDtoList.length;
      });
    });
    this.cartService.getAllShip().subscribe(data => {
      this.shipDtos = data;
      console.log(data);
      this.shipSelected = data[0];
    });
  }

  updateQualityMinus(quality: string, productId: string, ordersId: string) {
    // tslint:disable-next-line:radix
    if (parseInt(quality) - 1 >= 1) {
      // tslint:disable-next-line:radix
      this.cartService.updateQuality(ordersId, parseInt(quality) - 1).subscribe(() => {
        this.productCartDtos.forEach(value => {
          if (value.ordersId === ordersId) {
            // tslint:disable-next-line:radix
            value.quality = (parseInt(quality) - 1) + '';
          }
        });
        // tslint:disable-next-line:radix
        this.updateProductCartpay(ordersId, (parseInt(quality) - 1) + '');
      });
    }
  }

  updateQualityPlus(quality: string, productId: string, ordersId: string) {
    console.log('quality', quality);
    // tslint:disable-next-line:radix
    this.cartService.updateQuality(ordersId, parseInt(quality) + 1).subscribe(() => {
      this.productCartDtos.forEach(value => {
        if (value.ordersId === ordersId) {
          // tslint:disable-next-line:radix
          value.quality = (parseInt(quality) + 1) + '';
        }
      });
      // tslint:disable-next-line:radix
      this.updateProductCartpay(ordersId, (parseInt(quality) + 1) + '');
    });

  }
  updateProductCartpay(ordersId: string, quality: string) {
    if (this.checkProductPay(ordersId) > -1) {
      this.productCartPay.forEach(productCartPay => {
        if (productCartPay.ordersId == ordersId) {
          productCartPay.quality = quality;
        }
      });
      this.updateTotal();
      this.render();
    }
  }
  payOrder() {
    console.log();
  }

  addProduct(ordersId: string, i: number) {
    this.productCartDtos.forEach(value => {
      if (value.ordersId == ordersId) {
        if (this.checkProductPay(ordersId) === -1) {
          this.productCartPay.push(value);
        } else {
          this.productCartPay.splice(this.checkProductPay(ordersId), 1);
        }
      }
    });
    if (this.productCartPay.length === 0) {
      this.total = 0;
    } else {
      this.updateTotal();
    }
    this.render();
  }
  render() {
    render(
      {
        id: '#myPaypalButtons',
        currency: 'USD',
        value: this.total + '',
        onApprove: details => {
          this.total = 0;
          this.totalVnd = 0;
          this.cartService.payOrderDetail(this.productCartPay).subscribe(() => {
            this.productCartPay.forEach(productCartPay => {
              if (this.checkProductCartDtos(productCartPay.ordersId) > -1) {
                this.productCartDtos.splice(this.checkProductCartDtos(productCartPay.ordersId), 1);
              }
            });
            this.productCartPay = [];
          });
          this.toastService.success('Thanh toán thành công', '', {
            timeOut: 3000,
            positionClass: 'toast-top-right',
            progressBar: true,
            closeButton: true
          });
        }
      }
    );
  }
  getOrderDetailId(): string[] {
    this.productCartPay.forEach(value => {
      this.orderDetailList.push(value.ordersId);
    });
    return this.orderDetailList;
  }
  checkProductPay(ordersId: string): number {
    this.indexProductPay = -1;
    if (this.productCartPay) {
      this.productCartPay.forEach((value, index, array) => {
        if (value.ordersId == ordersId) {
          this.indexProductPay = index;
        }
      });
    }
    return this.indexProductPay;
  }
  checkProductCartDtos(ordersId: string): number {
    this.indexProductPay = -1;
    this.productCartDtos.forEach((value, index) => {
      if (value.ordersId == ordersId) {
        this.indexProductPay = index;
      }
    });
    return this.indexProductPay;
  }

  deleteOrderDetail(ordersId: string) {
    this.idDelete = ordersId;
    this.productCartDtos.forEach(value => {
      if (value.ordersId === this.idDelete) {
        this.productCartDelete = value;
      }
    });
  }

  deleteOrderDetailConfirm() {
    this.cartService.updateRemoveStatus(this.idDelete).subscribe(() => {
      if (this.checkProductCartDtos(this.idDelete) > -1) {
       this.productCartDtos.splice(this.checkProductCartDtos(this.idDelete), 1);
      }
      if (this.checkProductPay(this.idDelete) > -1) {
        this.productCartPay.splice(this.checkProductPay(this.idDelete), 1);
      }
    });
  }

  shipSelectedForOrders(e: any, i: number) {
    document.querySelectorAll('.ship__logo').forEach((value, key) => {
      value.classList.remove('active');
    });
    e.target.classList.toggle('active');
    this.shipSelected = this.shipDtos[i];
    this.updateTotal();
    console.log(this.shipSelected);
  }
  updateTotal() {
    this.total = 0;
    this.feeShip = 0;
    this.productCartPay.forEach(value => {
      // tslint:disable-next-line:radix
      this.total += parseInt(value.quality) * value.price * (100 - value.discountVal) / 100;
      // tslint:disable-next-line:radix
      this.feeShip += parseInt(value.quality) * value.weight;
      console.log('feee ship:', this.feeShip);
    });
    this.feeShip = (this.feeShip * this.shipSelected.fareWeight);
    this.total += this.feeShip;
    this.totalVnd = this.total;
    this.total = this.total / 23000;
    this.total = Number(this.total.toFixed(2));
  }

  setAddress(isLocationShipMe: boolean, idElemenAddressShow: string, idElementAddressHide) {
    document.getElementById(idElemenAddressShow).classList.toggle('hidden');
    document.getElementById(idElementAddressHide).classList.toggle('hidden');
    if (isLocationShipMe) {
      this.locationShip = this.customer.address_detail;
    } else {
      this.locationShip = this.getValue(document.getElementById('address__value--orther'));
    }
    this.setLocalShipForOrder();
    console.log(this.locationShip);
  }
  getValue(element: any): string {
    return element.value;
  }
  setValueLocationShipOrther() {
    this.locationShip = this.getValue(document.getElementById('address__value--orther'));
    this.setLocalShipForOrder();
    console.log(this.locationShip);
  }
  setLocalShipForOrder() {
    if (this.productCartPay) {
      this.productCartPay.forEach(value => {
        value.locationShip = this.locationShip;
      });
    }
  }

}
