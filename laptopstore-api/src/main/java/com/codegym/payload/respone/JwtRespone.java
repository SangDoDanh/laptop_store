package com.codegym.payload.respone;

import com.codegym.model.user.Account;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {
    private Integer id;
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private Account account;

    public JwtRespone(String token, Collection<? extends GrantedAuthority> roles,
                      Account account) {
        this.token = token;
        this.roles = roles;
        this.account = account;
    }

    public JwtRespone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
