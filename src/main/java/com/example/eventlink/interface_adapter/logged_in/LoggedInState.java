package com.example.eventlink.interface_adapter.logged_in;

import com.example.eventlink.entity.event.Event;

import java.util.List;

/**
 * The LoggedInState class represents the state of the main logged in page
 * that a user is viewing in the EventLink application.
 * It encapsulates information such as the user's provided name, and any messages that may need to be
 * displayed to convey changes (such as successful registration, creation, or modification of events).
 * <p>
 * This class provides getter and setter methods for each attribute),
 * allowing external classes to interact with and modify the state.
 * </p>
 *
 * @version 1.0
 */

public class LoggedInState {
    private String name = "";
    private String message = "";
    private final String WELCOME = "Welcome ";
    private List<Event> events;
    //Copy method
    public LoggedInState(LoggedInState copy) {
        this.name = copy.name;
        this.message = copy.message;
    }
    //Main init. method
    public LoggedInState() {}
    //name getter and setter.
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    //message getter and setter.
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    //WELCOME getter (WELCOME should never change, hence only the getter and no setter.)
    public String getWELCOME() {return WELCOME;}
    //events getter and setter
    public List<Event> getEvents() {return this.events;}
    public void setEvents(List<Event> events) {this.events = events;}
}
