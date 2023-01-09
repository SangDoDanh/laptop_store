import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../service/auth.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  rfSignUp: FormGroup;
  emailGoogle: string;

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.emailGoogle = params.get("email");
    });

    this.getSignupForm();
  }

  getSignupForm() {
    this.rfSignUp = this.formBuilder.group({
      username: ['123'],
      password: ['123'],
      name: ['123'],
      email: [this.emailGoogle]
    })
  }

  signUp() {
    this.authService.signUp(this.rfSignUp.value).subscribe(() => {
      this.toastr.success('Đăng ký thành công, mời bạn đăng nhập')
      this.router.navigateByUrl('/login')
    })
  }


}
