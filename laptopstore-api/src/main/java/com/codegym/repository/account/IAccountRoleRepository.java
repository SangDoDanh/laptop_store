package com.codegym.repository.account;

import com.codegym.model.user.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {
}
