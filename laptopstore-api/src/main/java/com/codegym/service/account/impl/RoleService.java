package com.codegym.service.account.impl;

import com.codegym.model.user.Role;
import com.codegym.model.user.RoleName;
import com.codegym.repository.account.IRoleRepository;
import com.codegym.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name.toString());
    }
}
