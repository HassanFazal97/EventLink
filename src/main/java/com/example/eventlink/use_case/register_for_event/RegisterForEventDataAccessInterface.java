package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.user.User;

public interface RegisterForEventDataAccessInterface {
    User getUsername(String username);

    void UpdateUser(User user);
}
