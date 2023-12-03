package com.example.eventlink.use_case.login;

import com.example.eventlink.entity.user.User;

public interface LoginUserDataAccessInterface {
    User getUser(String username);

}
