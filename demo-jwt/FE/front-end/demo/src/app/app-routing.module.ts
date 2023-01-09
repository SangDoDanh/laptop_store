import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {CustomerComponent} from "./customer/customer.component";
import {AuctionComponent} from "./auction/auction.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./security/auth.guard";
import {AdminGuard} from "./security/admin.guard";
import {SignupComponent} from "./signup/signup.component";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'auction', component: AuctionComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signUp', component: SignupComponent},
  {path: 'signUp/:email', component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
