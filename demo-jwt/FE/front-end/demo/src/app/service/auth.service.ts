import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SignInForm} from "../model/sign-in-form";
import {JwtRespone} from "../model/jwt-respone";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {MessageRespone} from "../model/message-respone";
import {Googletoken} from "../security/googletoken";
import {SignUpForm} from "../model/sign-up-form";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL_API = environment.URL_API;

  constructor(
    private httpClient: HttpClient,
  ) { }

  signIn(signInForm: SignInForm): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + '/api/auth/signin', signInForm);
  }

  googleLogin(googleToken: Googletoken): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + '/api/auth/google', googleToken)
  }

  signUp(signUpForm: SignUpForm): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + '/api/auth/signup', signUpForm);
  }

}
