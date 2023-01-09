import { Component, OnInit } from '@angular/core';
import {Customer} from "../model/customer";
import { CustomerService } from '../service/customer.service';
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customerList: Customer[] = [];

  constructor(
    private customerService: CustomerService,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getCustomerList();
  }

  getCustomerList() {
    this.customerService.getCustomerList().subscribe(data => {
      this.customerList = data;
    },error => {
      this.toastr.error('Chưa được xác thực back-end!')
    })
  }

}
