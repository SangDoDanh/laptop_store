package com.codegym.repository.account;

import com.codegym.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "SELECT * FROM role where name = :name", nativeQuery = true)
    Optional<Role> findByName(@Param("name") String name);
}
