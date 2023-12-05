package com.example.eventlink.use_case.create_events;

import com.example.eventlink.entity.event.Event;

import java.util.List;

/**
 * Interface for accessing and managing event data.
 * Provides methods for creating, retrieving, and listing events.
 */
public interface CreateEventDataAccessInterface {

    /**
     * Creates a new event with specified details.
     *
     * @param name        the name of the event
     * @param startDate   the start date of the event
     * @param startTime   the start time of the event
     * @param endDate     the end date of the event
     * @param endTime     the end time of the event
     * @param currency    the currency for the event's financial aspects
     * @param summary     a brief summary of the event
     * @param isPrivate   flag indicating if the event is private or public
     * @return            the created Event object
     */
    Event create(String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);

    /**
     * Retrieves an event by its ID.
     *
     * @param id  the ID of the event to retrieve
     * @return    the Event object with the specified ID
     */
    Event get(String id);

    /**
     * Retrieves a list of all events.
     *
     * @return a list of all Event objects
     */
    List<Event> getAllEvents();
}
