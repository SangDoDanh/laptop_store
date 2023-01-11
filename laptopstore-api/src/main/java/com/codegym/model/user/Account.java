package com.codegym.model.user;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    private String username;
    private String password;

    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoles;

    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToOne(mappedBy = "account")
    private Employee employee;
    @OneToMany(mappedBy = "account")
    private Set<AccountLock> accountLocks;

    public Account() {
    }

    public Account(String name, String username, String encode) {
        this.name = name;
        this.username = username;
        this.password = encode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Set<AccountLock> getAccountLocks() {
        return accountLocks;
    }

    public void setAccountLocks(Set<AccountLock> accountLocks) {
        this.accountLocks = accountLocks;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
