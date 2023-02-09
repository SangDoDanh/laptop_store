import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {TokenServiceService} from '../service/auth/token-service.service';
import {CustomerDto} from '../dto/customer-dto';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  customer: CustomerDto;
  constructor(private customerService: CustomerService,
              private tokenService: TokenServiceService,
              private titleService: Title) { }

  ngOnInit(): void {
    this.titleService.setTitle('Moki Tech | Thông tin của bạn');

    this.customerService.getCustomerByUSerId(this.tokenService.getId()).subscribe(data => {
      this.customer = data;
      console.log(data);
    });
  }

}
