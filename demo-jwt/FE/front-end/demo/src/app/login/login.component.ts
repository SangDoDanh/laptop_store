import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenService} from '../service/token.service';
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";
import {ToastrService} from 'ngx-toastr';
import {MessageRespone} from "../model/message-respone";
import {GoogleLoginProvider, SocialAuthService, SocialUser} from "angularx-social-login";
import {Googletoken} from "../security/googletoken";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogged: SocialUser;
  socialUser: SocialUser;
  rfLogin: FormGroup;
  isLogged: boolean;

  constructor(
    private authSocialService: SocialAuthService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router,
    private toastr: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.getFormLogin();

    this.authSocialService.authState.subscribe(data => {
      this.userLogged = data;
      this.isLogged = (this.userLogged != null);
    })

  }

  getFormLogin() {
    this.rfLogin = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      rememberMe: [false]
    })
  }

  login() {
    this.authService.signIn(this.rfLogin.value).subscribe(data => {
      if (data.token != undefined) {

        if (this.rfLogin.value.rememberMe) {
          this.tokenService.rememberMe(data.token, data.account, data.roles, data.user)
        } else {
          this.tokenService.setAccountSession(data.account);
          this.tokenService.setTokenSession(data.token);
          this.tokenService.setUserSession(data.user);
          this.tokenService.setRoleSession(data.roles)
        }

        this.router.navigate(['/home']).then(() => {
          location.reload();
        })
      }

    }, error => {

      const messageRespone: MessageRespone = error;

      if (messageRespone.message) {
        this.toastr.error('Không tìm thấy người dùng')
        this.router.navigateByUrl('/login')
      } else {
        this.toastr.error('Đăng nhập thất bại')
        this.router.navigateByUrl('/login')
        console.log('Đăng nhập thất bại')
      }

    })
  }

  loginWithGoogle() {
    this.authSocialService.signIn(GoogleLoginProvider.PROVIDER_ID).then(data => {
      this.socialUser = data;

      const googleToken = new Googletoken(this.socialUser.idToken)

      this.authService.googleLogin(googleToken).subscribe(req => {

        if (req.token == null) {
          const emailToRegister = req.email;

          this.router.navigateByUrl('/signUp/' + emailToRegister)

        } else {

          this.tokenService.setAccountLocal(req.account);
          this.tokenService.setTokenLocal(req.token);
          this.tokenService.setUserLocal(req.user);
          this.tokenService.setRoleLocal(req.roles)

          this.router.navigate(['/home']).then(() => {
            location.reload();
          })

        }
      })
    })
  }

}
