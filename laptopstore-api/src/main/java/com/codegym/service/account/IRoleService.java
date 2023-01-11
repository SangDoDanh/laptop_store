package com.codegym.service.account;


import com.codegym.model.user.Role;
import com.codegym.model.user.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
