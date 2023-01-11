package com.codegym.dto.request;

public class SignInForm {
    private String username;
    private String Password;

    public SignInForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
