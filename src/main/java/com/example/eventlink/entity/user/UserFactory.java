package com.example.eventlink.entity.user;

import com.example.eventlink.entity.event.Event;

import java.util.List;
public interface UserFactory {
    User create(String firstName, String lastName, String username, String password, List<Event> events, List<String> tags);
}
