package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.entity.event.Event;

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


    /**
     * Constructs a RegisterForEventState object by copying another instance.
     *
     * @param copy The RegisterForEventState instance to copy.
     */
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

    /**
     * Gets the username from the RegisterForEventState.
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username in the RegisterForEventState.
     *
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the error message of the username attribute during the registration process.
     *
     * @return usernameError The error message to be set for the username attribute.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Sets the error message for the username attribute during the registration process.
     *
     * @param usernameError The error message to be set for the username attribute.
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Gets the first name of the participant for the event registration.
     *
     * @return The first name of the participant.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the participant for the event registration.
     *
     * @param firstName The first name to be set for the participant.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the error associated with the first name attribute during the registration process.
     *
     * @return The error message for the first name attribute, or null if there is no error.
     */
    public String getFirstNameError() {
        return firstNameError;
    }


    /**
     * Sets the error message for the first name attribute during the registration process.
     *
     * @param firstNameError The error message to be set for the first name attribute.
     */
    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    /**
     * Gets the last name of the participant for the event registration.
     *
     * @return The last name of the participant.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the participant for the event registration.
     *
     * @param lastName The last name to be set for the participant.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the error associated with the last name attribute during the registration process.
     *
     * @return The error message for the last name attribute, or null if there is no error.
     */
    public String getLastNameError() {
        return lastNameError;
    }

    /**
     * Sets the error message for the last name attribute during the registration process.
     *
     * @param lastNameError The error message to be set for the last name attribute.
     */
    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    /**
     * Sets the event name based on the event object.
     *
     * @param eventName The event name to be set. It is derived from the associated event object.
     */
    public void setEventName(String eventName) {
        this.eventName = this.event.getName();
    }

    /**
     * Gets the name of the event for which registration is being performed.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the error message for the event name attribute during the registration process.
     *
     * @param eventNameError The error message to be set for the event name attribute.
     */
    public void setEventNameError(String eventNameError) {
        this.eventNameError = eventNameError;
    }

    /**
     * Gets the error associated with the event name attribute during the registration process.
     *
     * @return The error message for the event name attribute, or null if there is no error.
     */
    public String getEventNameError() {
        return eventNameError;
    }

    /**
     * Sets the event ID based on the event object.
     *
     * @param eventID The event ID to be set. It is derived from the associated event object.
     */
    public void setEventID(String eventID) {
        this.eventID = this.event.getID();
    }

    /**
     * Gets the ID of the event for which registration is being performed.
     *
     * @return The ID of the event.
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * Sets the error message for the event ID attribute during the registration process.
     *
     * @param eventIDError The error message to be set for the event ID attribute.
     */
    public void setEventIDError(String eventIDError) {
        this.eventIDError = eventIDError;
    }

    /**
     * Gets the error associated with the event ID attribute during the registration process.
     *
     * @return The error message for the event ID attribute, or null if there is no error.
     */
    public String getEventIDError() {
        return eventIDError;
    }

    /**
     * Gets the list of tags associated with the event registration.
     *
     * @return The list of tags for the event.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sets the list of tags for the event registration.
     *
     * @param tags The list of tags to be set for the event.
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Gets the error associated with the tags attribute during the registration process.
     *
     * @return The error messages for the tags attribute, or null if there is no error.
     */
    public List<String> getTagsError() {
        return tagsError;
    }

    /**
     * Sets the error messages for the tags attribute during the registration process.
     *
     * @param tagsError The error messages to be set for the tags attribute.
     */
    public void setTagsError(List<String> tagsError) {
        this.tagsError = tagsError;
    }

}

