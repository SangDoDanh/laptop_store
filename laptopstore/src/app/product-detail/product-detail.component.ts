import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductDto} from '../dto/product-dto';
import {ProductGroupService} from '../service/product-group.service';

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
  constructor(private router: Router,
              private routerActive: ActivatedRoute,
              private productService: ProductGroupService) { }

  ngOnInit(): void {
    this.id = this.routerActive.snapshot.params.id;
    this.productService.getProductById(this.id).subscribe(data => {
      this.product = data;
      this.ulrImgs = data.urlImgs.split(',');
      this.urlShow = this.ulrImgs[0];
    });
  }

  changImg(i: number) {
      this.urlShow = this.ulrImgs[i];
  }
}
