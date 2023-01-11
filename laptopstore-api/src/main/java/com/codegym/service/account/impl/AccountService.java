package com.codegym.service.account.impl;

import com.codegym.model.user.Account;
import com.codegym.repository.account.IAccountRepository;
import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository userRepository;

    @Override
    public Optional<Account> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Account save(Account user) {
        return userRepository.save(user);
    }
}
