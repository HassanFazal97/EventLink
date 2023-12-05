package com.example.eventlink.interface_adapter.create_events;

import javafx.scene.control.TextField;

/**
 * The CreateEventState class represents the state of an event
 * that a user is creating in the EventLink application.
 * It encapsulates information such as event details, and any errors that
 * may occur during the registration process for an event.
 * <p>
 * This class provides getter and setter methods for each attribute,
 * allowing external classes to interact with and modify the state.
 * </p>
 *
 * @version 1.0
 */

public class CreateEventState {
    private String userName = "";
    private String name = "";
    private String startDate = "";
    private String startTime= "";
    private String endDate = "";
    private String endTime = "";
    private final String CURRENCY = "CAD";
    private String summary = "";
    private Boolean isPrivate = false;
    private String error = "";

    /**
     * Copy constructor. Initializes a new instance by copying the state from another instance.
     *
     * @param copy The CreateEventState instance to copy from.
     */
    public CreateEventState(CreateEventState copy){
        this.userName = copy.userName;
        this.name = copy.name;
        this.startDate = copy.startDate;
        this.startTime = copy.startTime;
        this.endDate = copy.endDate;
        this.endTime = copy.endTime;
        this.summary = copy.summary;
        this.isPrivate = copy.isPrivate;
        this.error = copy.error;
    }

    /**
     * Default constructor. Initializes a new instance of CreateEventState with default values.
     */
    public CreateEventState() {}

    /**
     * Gets the user name associated with the event.
     *
     * @return The user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name associated with the event.
     *
     * @param userName The user name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the name of the event.
     *
     * @return The event name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event.
     *
     * @param name The event name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the start date of the event.
     *
     * @return The start date.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the event.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the start time of the event.
     *
     * @return The start time.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the event.
     *
     * @param startTime The start time to set.
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end date of the event.
     *
     * @return The end date.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the event.
     *
     * @param end The end date to set.
     */
    public void setEndDate(String end) {
        this.endDate = end;
    }

    /**
     * Gets the end time of the event.
     *
     * @return The end time.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the event.
     *
     * @param endTime The end time to set.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the currency used for the event. The currency is a constant set to "CAD".
     *
     * @return The currency.
     */
    public String getCurrency() {
        return CURRENCY;
    }

    /**
     * Gets the summary of the event.
     *
     * @return The event summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the summary of the event.
     *
     * @param summary The summary to set.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the privacy status of the event.
     *
     * @return The privacy status.
     */
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    /**
     * Sets the privacy status of the event.
     *
     * @param isPrivate The privacy status to set.
     */
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    /**
     * Gets the error message, if any, that occurred during the event creation process.
     *
     * @return The error message.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message that may occur during the event creation process.
     *
     * @param error The error message to set.
     */
    public void setError(String error) {
        this.error = error;
    }

}
