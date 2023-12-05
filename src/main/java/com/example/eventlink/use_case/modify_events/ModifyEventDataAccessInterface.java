/**
 * This interface defines the data access methods for modifying events in the system.
 * It provides functionality to check the existence of an event, modify event details,
 * remove event, retrieve all events, and get details of a specific event.
 */

package com.example.eventlink.use_case.modify_events;
import com.example.eventlink.entity.event.Event;

import java.util.List;

public interface ModifyEventDataAccessInterface {

    /**
     * Checks if an event with the given ID exists in the system.
     *
     * @param id The ID of the event to check.
     * @return True if an event with the given ID exists, false otherwise.
     */
    boolean existsById(String id);

    /**
     * Modifies the details of an existing event with the provided information.
     *
     * @param id          The ID of the event to modify.
     * @param name        The modified name of the event.
     * @param startDate   The modified start date of the event.
     * @param startTime   The modified start time of the event.
     * @param endDate     The modified end date of the event.
     * @param endTime     The modified end time of the event.
     * @param currency    The modified currency for the event.
     * @param summary     The modified summary of the event.
     * @param isPrivate   The modified privacy status of the event.
     * @return A string indicating the result of the modification operation.
     */
    String modify(String id, String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);

    /**
     * Removes an event with the given ID from the system.
     *
     * @param id The ID of the event to remove.
     */
    void remove(String id);

    /**
     * Retrieves a list of all events in the system.
     *
     * @return A list of Event objects representing all events in the system.
     */
    List<Event> getAllEvents();

    /**
     * Retrieves the details of an event with the given ID.
     *
     * @param eventID The ID of the event to retrieve.
     * @return An Event object containing the details of the specified event.
     */
    Event get(String eventID);
}
