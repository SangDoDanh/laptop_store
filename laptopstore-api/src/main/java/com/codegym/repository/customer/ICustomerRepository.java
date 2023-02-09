package com.codegym.repository.customer;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.*\n" +
            "from account join customer c on account.id = c.account_id\n" +
            "where account_id = :idAccount ", nativeQuery = true)
    Optional<Customer> findByIdAccount(@Param("idAccount") Integer idAccount);

    @Query(value = "select c.id, " +
            "c.email, " +
            "c.first_name, " +
            "c.last_name, " +
            "c.phone, " +
            "a.address_detail, " +
            "c.birth_day, " +
            "c.gender, " +
            "ct.name as customerName, " +
            "c.dedication_point as customerPoint " +
            "from account join customer c on account.id = c.account_id " +
            "           join address a on a.customer_id = c.id " +
            "           join customer_type ct on ct.id = c.customer_type_id\n " +
            "where account_id = :accountId ", nativeQuery = true)
    CustomerDto getCustomerByAccountId(@Param("accountId") Integer accountId);
}
