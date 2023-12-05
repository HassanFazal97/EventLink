/**
 * The ModifyState class represents the state of the modify events view.
 * It encapsulates information about the user's input, event details, and any error messages.
 */

package com.example.eventlink.interface_adapter.modify_events;

public class ModifyState {

    /**
     * The user's name associated with the modification state.
     */
    private String userName = "";

    /**
     * The name of the event in the modification state.
     */
    private String name = "";

    /**
     * The start date of the event in the modification state.
     */
    private String startDate = "";

    /**
     * The start time of the event in the modification state.
     */
    private String startTime = "";

    /**
     * The end date of the event in the modification state.
     */
    private String endDate = "";

    /**
     * The end time of the event in the modification state.
     */
    private String endTime = "";

    /**
     * The currency of the event in the modification state.
     */
    private String currency = "";

    /**
     * The summary of the event in the modification state.
     */
    private String summary = "";

    /**
     * The privacy status of the event in the modification state.
     */
    private Boolean isPrivate = false;

    /**
     * The ID of the event in the modification state.
     */
    private String id = "";

    /**
     * Any error message associated with the modification state.
     */
    private String error = "";

    /**
     * Constructs a new ModifyState with default values.
     */
    public ModifyState() {}

    /**
     * Gets the user's name associated with the modification state.
     *
     * @return The user's name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's name associated with the modification state.
     *
     * @param userName The user's name to set.
     */
    public void setUserName(String userName) {this.userName = userName;}

    /**
     * Gets the name of the event in the modification state.
     *
     * @return The name of the event.
     */
    public String getName() {return name;}

    /**
     * Sets the name of the event in the modification state.
     *
     * @param name The name of the event to set.
     */
    public void setName(String name) {this.name = name;}

    /**
     * Gets the start date of the event in the modification state.
     *
     * @return The start date of the event.
     */
    public String getStartDate() {return startDate;}

    /**
     * Sets the start date of the event in the modification state.
     *
     * @param startDate The start time of the event to set.
     */
    public void setStartDate(String startDate) {this.startDate = startDate;}

    /**
     * Gets the start time of the event in the modification state.
     *
     * @return The start time of the event.
     */
    public String getStartTime() {return startTime;}

    /**
     * Sets the start time of the event in the modification state.
     *
     * @param startTime The start time of the event to set.
     */
    public void setStartTime(String startTime) {this.startTime = startTime;}

    /**
     * Gets the end time of the event in the modification state.
     *
     * @return The end time of the event.
     */
    public String getEndTime() {return endTime;}

    /**
     * Sets the end time of the event in the modification state.
     *
     * @param endTime The end time of the event to set.
     */
    public void setEndTime(String endTime) {this.endTime = endTime;}

    /**
     * Gets the end date of the event in the modification state.
     *
     * @return The end date of the event.
     */
    public String getEndDate() {return endDate;}

    /**
     * Sets the end date of the event in the modification state.
     *
     * @param endDate The end date of the event to set.
     */
    public void setEndDate(String endDate) {this.endDate = endDate;}

    /**
     * Gets the currency of the event in the modification state.
     *
     * @return The currency of the event.
     */
    public String getCurrency() {return currency;}

    /**
     * Sets the currency of the event in the modification state.
     *
     * @param currency The currency of the event to set.
     */
    public void setCurrency(String currency) {this.currency = currency;}

    /**
     * Gets the summary of the event in the modification state.
     *
     * @return The summary of the event.
     */
    public String getSummary() {return summary;}

    /**
     * Sets the summary of the event in the modification state.
     *
     * @param summary The summary of the event to set.
     */
    public void setSummary(String summary) {this.summary = summary;}

    /**
     * Gets the privacy status of the event in the modification state.
     *
     * @return The privacy status of the event (true if private, false if not).
     */
    public Boolean getIsPrivate() {return isPrivate;}

    /**
     * Sets the privacy status of the event in the modification state.
     *
     * @param isPrivate The privacy status to set (true if private, false if not).
     */
    public void setIsPrivate(Boolean isPrivate) {this.isPrivate = isPrivate;}

    /**
     * Gets the ID of the event in the modification state.
     *
     * @return The ID of the event.
     */
    public String getId() {return id;}

    /**
     * Sets the ID of the event in the modification state.
     *
     * @param id The ID of the event to set.
     */
    public void setId(String id) {this.id = id;}

    /**
     * Gets the error message associated with the modification state.
     *
     * @return The error message.
     */
    public String getError(){return error;}

    /**
     * Sets the error message for the modification state.
     *
     * @param error The error message to set.
     */
    public void setError(String error) {this.error = error;}
}
