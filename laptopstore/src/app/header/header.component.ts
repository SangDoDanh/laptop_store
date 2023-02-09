import { Component, OnInit } from '@angular/core';
import {TokenServiceService} from '../service/auth/token-service.service';
import {CartService} from '../service/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  checkLogin = false;
  quality: number;
  nameLogin: string;
  constructor(private tokenService: TokenServiceService,
              private carService: CartService) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.nameLogin = this.tokenService.getName();
      this.carService.getAllProductCartByUserId(this.tokenService.getId())
      this.quality = this.carService.quality;
    }
  }

  logout() {
    localStorage.clear();
    window.location.reload();
  }
}
