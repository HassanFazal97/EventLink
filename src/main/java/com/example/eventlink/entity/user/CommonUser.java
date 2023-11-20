package com.example.eventlink.entity.user;

import com.example.eventlink.entity.event.Event;

import entity.event.Event;

import java.util.List;
public class CommonUser implements User {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final List<String> tags;
    private final List<Event> events;

    CommonUser(String firstName, String lastName, String username, String password, List<Event> events, List<String> tags) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.events = events;
        this.tags = tags;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }
}
