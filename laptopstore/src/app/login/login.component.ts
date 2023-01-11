import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AuthServiceService} from '../service/auth/auth-service.service';
import {TokenServiceService} from '../service/auth/token-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  rfLogin: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private authService: AuthServiceService,
              private tokenService: TokenServiceService,
              private router: Router) { }

  ngOnInit(): void {
    this.rfLogin = this.formBuilder.group({
      username: [''],
      password: ['']
    });
  }

  login() {
    console.log(this.rfLogin.value);
    this.authService.signIn(this.rfLogin.value).subscribe(data => {
      console.log('data---> ', data);
      if (data.token != undefined) {
        this.tokenService.setToken(data.token);
        this.tokenService.setName(data.name);
        this.tokenService.setRoles(data.roles);
        this.router.navigate(['']);
      }
      if (data.status == 202) {
        console.log('login fail!');
      }
    });
  }
}
