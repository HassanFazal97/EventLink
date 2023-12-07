package com.example.eventlink.entity;

public class SimplePasswordValidatorService implements PasswordValidator{
    @Override
    public boolean passwordIsValid(String password) {
        return password != null && password.length() >= 6;
    }
}
