package com.example.eventlink.data_access;

import com.example.eventlink.entity.event.*;
import com.example.eventlink.entity.user.*;
import com.example.eventlink.use_case.create_events.CreateEventDataAccessInterface;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;
import com.example.eventlink.use_case.modify_events.ModifyEventDataAccessInterface;
import com.example.eventlink.use_case.register_for_event.RegisterForEventDataAccessInterface;
import com.example.eventlink.use_case.signup.SignupUserDataAccessInterface;
import com.example.eventlink.use_case.view_event.ViewEventDataAccessInterface;

import java.io.IOException;
import java.util.*;

public class TestDataAccessObject implements AbstractEventDataAccessObject,
        AbstractUserDataAccessObject, SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, ViewEventDataAccessInterface,
        ModifyEventDataAccessInterface, CreateEventDataAccessInterface,
        RegisterForEventDataAccessInterface {
    private static int idNum = 0;
    private final Map<String, Event> events = new HashMap<String, Event>();
    private final Map<String, User> users = new HashMap<String, User>();
    private EventFactory eventFactory;
    public TestDataAccessObject(EventFactory eventFactory) throws IOException {
        this.eventFactory = eventFactory;

    }

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public Event get(String id) {
        return events.get(id);
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventsList = new ArrayList<Event>();
        for (String k: events.keySet()) {
            eventsList.add(events.get(k));
        }
        return eventsList;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public boolean existsByName(String username) {
        return users.containsKey(username);
    }

    @Override
    public boolean existsById(String id) {
        return events.containsKey(id);
    }

    @Override
    public Event create(String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate) {
        if(name.equals("")) {
            raiseException();
        }
        String start = startDate + "T" + startTime + ":00Z";
        String end = endDate + "T" + endTime + ":00Z";
        Event event = eventFactory.create(String.valueOf(idNum), name, start, end, currency, summary, isPrivate);
        events.put(event.getID(), event);
        idNum += 1;
        return event;
    }

    @Override
    public void remove(String id) {
        events.remove(id);
    }

    @Override
    public String modify(String id, String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate) {
        if (name.equals("")) {
            raiseException();
        }
        String start = startDate + "T" + startTime + ":00Z";
        String end = endDate + "T" + endTime + ":00Z";
        Event event = this.get(id);
        event.setName(name);
        event.setStart(start);
        event.setEnd(end);
        event.setCurrency(currency);
        event.setSummary(summary);
        event.setIsPrivate(isPrivate);
        events.put(id, event);
        return id;
    }

    @Override
    public void updateUser(String username, User user) {
        users.put(username, user);
    }

    private void raiseException() {
        throw new IllegalArgumentException("Exception raised during data storage procedures");
    }


}
