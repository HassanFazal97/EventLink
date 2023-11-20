package com.example.eventlink.use_case.signup;
import com.example.eventlink.entity.user.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String username);

    void save(User user);
}
