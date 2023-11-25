package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.user.CommonUser;

public interface RegisterForEventDataAccessInterface {
    CommonUser getUsername(String username);

    void UpdateUser(CommonUser commonUser);
}
