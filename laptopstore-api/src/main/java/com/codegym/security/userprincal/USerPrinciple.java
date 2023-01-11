package com.codegym.security.userprincal;

import com.codegym.model.user.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class USerPrinciple implements UserDetails {
    private Integer id;
    private String name;
    private String userName;
    @JsonIgnore
    private String password;

    private Collection<? extends  GrantedAuthority> roles;

    public USerPrinciple() {
    }

    public USerPrinciple(Integer id, String name, String userName, String password, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }


    public static USerPrinciple build(Account user) {
        List<GrantedAuthority> authorities = user.getAccountRoles().stream().map(role ->
           new SimpleGrantedAuthority(role.getRole().getName())).collect(Collectors.toList());
        return new USerPrinciple(user.getId(), user.getName(), user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
