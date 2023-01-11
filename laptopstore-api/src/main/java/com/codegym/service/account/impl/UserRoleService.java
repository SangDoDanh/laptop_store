package com.codegym.service.account.impl;

import com.codegym.model.user.AccountRole;
import com.codegym.repository.account.IAccountRoleRepository;
import com.codegym.service.account.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IAccountRoleService {
    @Autowired
    private IAccountRoleRepository userRoleRepository;
    @Override
    public void save(AccountRole aRole) {
        userRoleRepository.save(aRole);
    }
}
