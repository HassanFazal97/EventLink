package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.interface_adapter.signup.SignupState;

import java.util.List;

/**
 * The RegisterForEventState class represents the state of the user's registration
 * for an event in the EventLink application.
 * It encapsulates information such as user details,event details, and any errors that
 * may occur during the registration process for an event.
 * <p>
 * This class provides getter and setter methods for each attribute, allowing external classes
 * to interact with and modify the state.
 * </p>
 *
 * @version 1.0
 */

public class RegisterForEventState {
    private String username = "";
    private String usernameError = null;
    private String firstName = "";
    private String firstNameError = null;
    private String lastName = "";
    private String lastNameError = null;
    private Event event;
    private String eventName = "";
    private String eventNameError = null;
    private String eventID = "";
    private String eventIDError = null;
    private List<String> tags = null;
    private List<String> tagsError = null;


    public RegisterForEventState(RegisterForEventState copy) {
        /*
         * Default constructor for RegisterForEventState.
         */
        username = copy.getUsername();
        usernameError = copy.getUsernameError();
        firstName = copy.getFirstName();
        firstNameError = copy.getFirstNameError();
        lastName = copy.getLastName();
        lastNameError = copy.getLastNameError();
        event = copy.event;
        eventName = copy.getEventName();
        eventNameError = copy.getEventNameError();
        eventID = copy.getEventID();
        eventIDError = copy.getEventIDError();
        tags = copy.getTags();
        tagsError = copy.getTagsError();
    }

    public RegisterForEventState() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public void setEventName(String eventName) {
        this.eventName = this.event.getName();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventNameError(String eventNameError) {
        this.eventNameError = eventNameError;
    }

    public String getEventNameError() {
        return eventNameError;
    }

    public void setEventID(String eventID) {
        this.eventID = this.event.getID();
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventIDError(String eventIDError) {
        this.eventIDError = eventIDError;
    }

    public String getEventIDError() {
        return eventIDError;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTagsError() {
        return tagsError;
    }

    public void setTagsError(List<String> tagsError) {
        this.tagsError = tagsError;
    }

}

