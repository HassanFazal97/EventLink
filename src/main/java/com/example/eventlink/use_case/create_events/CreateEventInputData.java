package com.example.eventlink.use_case.create_events;

/**
 * Class representing the data necessary for creating an event.
 * This includes information such as event name, start/end dates and times,
 * currency, summary, and privacy status.
 */
public class CreateEventInputData {

    private final String name;
    private final String startDate;
    private final String startTime;
    private final String endDate;
    private final String endTime;
    private final String currency;
    private final String summary;
    private final Boolean isPrivate;

    /**
     * Constructs a new CreateEventInputData with the specified details.
     *
     * @param name       the name of the event
     * @param startDate  the start date of the event
     * @param startTime  the start time of the event
     * @param endDate    the end date of the event
     * @param endTime    the end time of the event
     * @param currency   the currency used for the event
     * @param summary    a brief summary of the event
     * @param isPrivate  the privacy status of the event (true for private, false for public)
     */
    public CreateEventInputData(String name, String startDate, String startTime, String endDate,
                                String endTime, String currency, String summary, Boolean isPrivate){
        this.name = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }

    // Getter methods with Javadoc comments

    /**
     * Returns the name of the event.
     * @return the event name
     */
    public String getName() { return name; }

    /**
     * Returns the start date of the event.
     * @return the start date
     */
    public String getStartDate() { return startDate; }

    /**
     * Returns the start time of the event.
     * @return the start time
     */
    public String getStartTime() { return startTime; }

    /**
     * Returns the end date of the event.
     * @return the end date
     */
    public String getEndDate() { return endDate; }

    /**
     * Returns the end time of the event.
     * @return the end time
     */
    public String getEndTime() { return endTime; }

    /**
     * Returns the currency used for the event.
     * @return the currency
     */
    public String getCurrency() { return currency; }

    /**
     * Returns a brief summary of the event.
     * @return the event summary
     */
    public String getSummary() { return summary; }

    /**
     * Returns the privacy status of the event.
     * @return true if the event is private, false otherwise
     */
    public Boolean getIsPrivate() { return isPrivate; }
}
