package com.example.eventlink.data_access;

import com.example.eventlink.entity.user.User;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;

public class UserDataAccessObject implements LoginUserDataAccessInterface {

    @Override
    public User get(String username) {
        return null;
    }
}
