package com.example.eventlink.entity.event;

/**
 * Interface representing an event in the EventLink application.
 * Defines methods to access and modify event details such as ID, name, start and end times,
 * currency, summary, and privacy status.
 */
public interface Event {

    /**
     * Returns the unique identifier of the event.
     *
     * @return the event ID
     */
    String getID();

    /**
     * Returns the name of the event.
     *
     * @return the event name
     */
    String getName();

    /**
     * Returns the start time of the event.
     *
     * @return the start time
     */
    String getStart();

    /**
     * Returns the end time of the event.
     *
     * @return the end time
     */
    String getEnd();

    /**
     * Returns the currency used for the event.
     *
     * @return the currency
     */
    String getCurrency();

    /**
     * Returns a summary of the event.
     *
     * @return the event summary
     */
    String getSummary();

    /**
     * Returns the privacy status of the event.
     *
     * @return true if the event is private, false otherwise
     */
    Boolean getIsPrivate();

    /**
     * Sets the name of the event.
     *
     * @param name the name to set
     */
    void setName(String name);

    /**
     * Sets the start time of the event.
     *
     * @param start the start time to set
     */
    void setStart(String start);

    /**
     * Sets the end time of the event.
     *
     * @param end the end time to set
     */
    void setEnd(String end);

    /**
     * Sets the currency used for the event.
     *
     * @param currency the currency to set
     */
    void setCurrency(String currency);

    /**
     * Sets a summary for the event.
     *
     * @param summary the summary to set
     */
    void setSummary(String summary);

    /**
     * Sets the privacy status of the event.
     *
     * @param isPrivate the privacy status to set
     */
    void setIsPrivate(Boolean isPrivate);
}
