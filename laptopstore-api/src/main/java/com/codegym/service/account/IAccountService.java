package com.codegym.service.account;


import com.codegym.model.user.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String name);
    Boolean existsByUsername(String username);
    Account save(Account account);
}
