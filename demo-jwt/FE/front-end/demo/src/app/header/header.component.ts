import {Component, OnInit} from '@angular/core';
import {TokenService} from "../service/token.service";
import {Router} from "@angular/router";
import {Account} from "../model/account";
import {User} from "../model/user";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  nameAccount: string;
  checkLogin = false;
  accountRole: string;
  currentAccount: Account;
  currentUser: User;


  constructor(
    private tokenService: TokenService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    if (this.tokenService.isLogged()) {
      this.checkLogin = true;

      this.currentUser = JSON.parse(this.tokenService.getUser());

      this.nameAccount = this.currentUser.name;

      const roles = this.tokenService.getRole();

      for (let i = 0; i < roles.length; i++) {
        if (roles[i] === "ROLE_ADMIN") {
          this.accountRole = "ROLE_ADMIN"
        }
      }
    }
  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl('/home').then(() => {
      location.reload();
    })
  }

}
