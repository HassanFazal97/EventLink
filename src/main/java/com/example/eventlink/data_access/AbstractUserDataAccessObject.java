package com.example.eventlink.data_access;

import com.example.eventlink.entity.user.*;

public interface AbstractUserDataAccessObject {

    public void save(User user);
    public User getUser(String username);
    public boolean existsByName(String username);

}
