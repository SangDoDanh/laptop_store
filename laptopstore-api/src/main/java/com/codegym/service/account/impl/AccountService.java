package com.codegym.service.account.impl;

import com.codegym.model.user.Account;
import com.codegym.repository.account.IAccountRepository;
import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;




    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }





}
