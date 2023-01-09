import {Account} from "./account";
import {User} from "./user";

export interface JwtRespone {
  token?: string;
  roles?: any[];
  account?: Account;
  user?: User;
  email?: string
}
