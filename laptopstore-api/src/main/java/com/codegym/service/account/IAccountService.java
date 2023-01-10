package com.codegym.service.account;


import com.codegym.model.user.Account;

public interface IAccountService {



    Account findAccountByUsername(String username);

}
