package com.example.eventlink.entity.event;

/**
 * Represents a common event in the EventLink application.
 * This class implements the Event interface and encapsulates details of an event,
 * including its unique identifier, name, start and end times, currency, summary, and privacy status.
 *
 * <p>It provides methods to retrieve and modify these event details.</p>
 */
public class CommonEvent implements Event {

    /**
     * The unique identifier of the event.
     */
    private final String id;

    /**
     * The name of the event.
     */
    private String name;

    /**
     * The start time of the event.
     */
    private String start;

    /**
     * The end time of the event.
     */
    private String end;

    /**
     * The currency used in the event.
     */
    private String currency;

    /**
     * A summary of the event.
     */
    private String summary;

    /**
     * Indicates whether the event is private.
     */
    private Boolean isPrivate;

    /**
     * Constructs a new CommonEvent with the specified details.
     *
     * @param id        The unique identifier of the event.
     * @param name      The name of the event.
     * @param start     The start time of the event.
     * @param end       The end time of the event.
     * @param currency  The currency used in the event.
     * @param summary   A summary of the event.
     * @param isPrivate Indicates whether the event is private.
     */
    CommonEvent(String id, String name, String start, String end,
                String currency, String summary, Boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }

    // Override methods from the Event interface with appropriate JavaDoc...

    /**
     * Gets the unique identifier of the event.
     *
     * @return The unique identifier of the event.
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Gets the name of the event.
     *
     * @return The name of the event.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the start time of the event, formatted to remove the timezone information.
     *
     * @return The formatted start time of the event.
     */
    @Override
    public String getStart() {
        return start.replace(":00Z", "").replace("T", " ");
    }

    /**
     * Gets the end time of the event, formatted to remove the timezone information.
     *
     * @return The formatted end time of the event.
     */
    @Override
    public String getEnd() {
        return end.replace(":00Z", "").replace("T", " ");
    }

    /**
     * Gets the currency used for the event.
     *
     * @return The currency of the event.
     */
    @Override
    public String getCurrency() {
        return currency;
    }

    /**
     * Gets a summary of the event.
     *
     * @return The summary of the event.
     */
    @Override
    public String getSummary() {
        return summary;
    }

    /**
     * Gets the privacy status of the event.
     *
     * @return The privacy status of the event.
     */
    @Override
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    /**
     * Sets the name of the event.
     *
     * @param name The name of the event to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the start time of the event.
     *
     * @param start The start time of the event to set.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Sets the end time of the event.
     *
     * @param end The end time of the event to set.
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Sets the currency used in the event.
     *
     * @param currency The currency of the event to set.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Sets the summary of the event.
     *
     * @param summary The summary of the event to set.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Sets the privacy status of the event.
     *
     * @param isPrivate The privacy status of the event to set.
     */
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
