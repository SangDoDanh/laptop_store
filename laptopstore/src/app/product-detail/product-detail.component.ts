import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductDto} from '../dto/product-dto';
import {ProductGroupService} from '../service/product-group.service';
import {ProductDetailList} from '../dto/product-detail-list';
import {TokenServiceService} from '../service/auth/token-service.service';
import {CartService} from '../service/cart.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  id: number;
  ulrImgs: string[] = [];
  product: ProductDto;
  urlShow: string;
  productDetailList: ProductDetailList[];
  productDetailSelected: ProductDetailList;
  isAddToCart = true;

  constructor(private router: Router,
              private routerActive: ActivatedRoute,
              private productService: ProductGroupService,
              private tokenService: TokenServiceService,
              protected cartService: CartService,
              private toastService: ToastrService,
              private titleService: Title) {
  }

  ngOnInit(): void {
    this.titleService.setTitle('Moki Tech | Chi tiết sản phẩm');
    this.id = this.routerActive.snapshot.params.id;
    console.log(this.id, 'idd');
    this.productService.getProductById(this.id).subscribe(data => {
      this.product = data;
      this.ulrImgs = data.urlImgs.split(',');
      this.urlShow = this.ulrImgs[0];
    });
    this.productService.getAllProductDetailByProductgroupId(this.id).subscribe(data => {
      this.productDetailList = data;
      console.log(data);
      this.productDetailSelected = data[0];
    });
  }

  changImg(i: number) {
    document.querySelectorAll('.images__item').forEach((value, key) => {
      value.classList.remove('active');
    });
    document.querySelector('.images__item' + i).classList.toggle('active');
    this.urlShow = this.ulrImgs[i];
  }

  changeProductDetailSelected(i: any, productDetail: any) {
    this.clearActive();
    document.querySelector('.configuration--item' + i).classList.toggle('active');
    this.productDetailSelected = productDetail;
    console.log('asdsadasdas');
  }

  clearActive() {
    document.querySelectorAll('.configuration--item').forEach(value => {
      value.classList.remove('active');
    });
  }

  AddToCart() {
    this.cartService.getAllProductCartByUserId(this.tokenService.getId()).subscribe(data => {
      if (!data) {
        console.log('zoday');
        this.productService.addToCart(this.tokenService.getId(), this.productDetailSelected.id).subscribe(() => {
          console.log('add to cart success!');
        });
      } else {
        data.forEach(value => {
          // tslint:disable-next-line:triple-equals
          if (value.id == this.productDetailSelected.id) {
            // tslint:disable-next-line:radix
            this.cartService.updateQuality(value.ordersId, parseInt(value.quality) + 1).subscribe(() => {
              console.log('update success!');
            });
            this.isAddToCart = false;
          }
        });
        if (this.isAddToCart) {
          this.productService.addToCart(this.tokenService.getId(), this.productDetailSelected.id).subscribe(() => {
            console.log('add to cart success!');
          });
        } else {
          this.isAddToCart = true;
        }
      }
      this.toastService.success('Đã thêm vào giỏ hàng', '', {
        timeOut: 3000,
        progressBar: true,
        positionClass: 'toast-top-right',
        closeButton: true
      });
    });
  }
}
