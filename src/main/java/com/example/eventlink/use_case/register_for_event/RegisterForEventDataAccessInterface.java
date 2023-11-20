package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.user.CommonUser;

public interface RegisterForEventDataAccessInterface {
    void UpdateUser(CommonUser commonUser);

    CommonUser getUsername(String username);
}
