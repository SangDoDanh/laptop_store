import { Injectable } from '@angular/core';
const TOKEN_KEY = 'token_key';
const NAME_KEY = 'name_key';
const ROLE_KEY = 'role_key';
const ID_KEY = 'id_key';


@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {
  public roles = [];

  constructor() { }

  public getId(): string {
    return localStorage.getItem(ID_KEY);
  }
  public setId(id: any) {
    localStorage.removeItem(ID_KEY);
    localStorage.setItem(ID_KEY, id);
  }
  public setToken(token: string ) {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }
  public getToken(): string {
    return localStorage.getItem(TOKEN_KEY);
  }

  public setName(name: string ) {
    localStorage.removeItem(NAME_KEY);
    localStorage.setItem(NAME_KEY, name);
  }
  public getName(): string {
    return localStorage.getItem(NAME_KEY);
  }

  public setRoles(roles: string[]) {
    localStorage.removeItem(ROLE_KEY);
    localStorage.setItem(ROLE_KEY, JSON.stringify(roles));
  }
  public getRoles(): string[] {
    if (this.getToken()) {
      this.roles = [];
      JSON.parse(localStorage.getItem(ROLE_KEY)).forEach(role => {
        this.roles.push(role.authority);
      });
    }
    return this.roles;
  }
}
