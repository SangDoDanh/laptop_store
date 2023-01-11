package com.codegym.repository.account;

import com.codegym.model.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {


    Optional<Account> findByUsername(String name);

    Boolean existsByUsername(String username);
}
