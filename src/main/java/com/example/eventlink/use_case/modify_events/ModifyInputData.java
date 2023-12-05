/**
 * This class represents the input data for the modify events use case.
 * It encapsulates the details needed for modifying an event, such as event ID, name, dates, times,
 * currency, summary, and privacy status.
 */

package com.example.eventlink.use_case.modify_events;

public class ModifyInputData {

    /**
     * The event id.
     */
    private final String id;

    /**
     * The event name.
     */
    private final String name;

    /**
     * The event start date.
     */
    private final String startDate;

    /**
     * The event start starting time.
     */
    private final String startTime;

    /**
     * The event start end date.
     */
    private final String endDate;

    /**
     * The event start ending time.
     */
    private final String endTime;

    /**
     * The currency for this event.
     */
    private final String currency;

    /**
     * A short summary describing this event.
     */
    private final String summary;

    /**
     * Whether or not the event is private.
     */
    private final Boolean isPrivate;


    /**
     * Constructs a new ModifyInputData object with the provided details.
     *
     * @param id        The ID of the event to modify.
     * @param name      The modified name of the event.
     * @param startDate The modified start date of the event.
     * @param startTime The modified start time of the event.
     * @param endDate   The modified end date of the event.
     * @param endTime   The modified end time of the event.
     * @param currency  The modified currency for the event.
     * @param summary   The modified summary of the event.
     * @param isPrivate The modified privacy status of the event.
     */
    public ModifyInputData(String id, String name, String startDate,String startTime, String endDate,
                           String endTime, String currency, String summary, Boolean isPrivate){
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }

    /**
     * Gets the ID of the event.
     *
     * @return The ID of the event.
     */
    public String getId() { return id; }

    /**
     * Gets the name of the event.
     *
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the start date of the event.
     *
     * @return The start date of the event.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Gets the start time of the event.
     *
     * @return The start time of the event.
     */
    public String getStartTime(){return startTime;}

    /**
     * Gets the end date of the event.
     *
     * @return The end date of the event.
     */
    public String getEndDate() {return endDate;}

    /**
     * Gets the end time of the event.
     *
     * @return The end time of the event.
     */
    public String getEndTime(){return endTime;}

    /**
     * Gets the currency of the event.
     *
     * @return The currency of the event.
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * Gets the summary of the event.
     *
     * @return The summary of the event.
     */
    public String getSummary(){
        return summary;
    }

    /**
     * Gets the privacy status of the event.
     *
     * @return The privacy status of the event.
     */
    public Boolean getIsPrivate(){
        return isPrivate;
    }

}
