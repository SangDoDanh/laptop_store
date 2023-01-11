import { Component, OnInit } from '@angular/core';
import {TokenServiceService} from '../service/auth/token-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  checkLogin = false;
  nameLogin: string;
  constructor(private tokenService: TokenServiceService) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.nameLogin = this.tokenService.getName();
    }
  }

}
