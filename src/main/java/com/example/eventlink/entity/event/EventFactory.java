package com.example.eventlink.entity.event;

/**
 * Interface for a factory that creates Event objects.
 * Defines a method to instantiate new Event instances with specific attributes.
 */
public interface EventFactory {

    /**
     * Creates and returns a new Event object with the specified details.
     *
     * @param id        the unique identifier for the event
     * @param name      the name of the event
     * @param start     the start time of the event
     * @param end       the end time of the event
     * @param currency  the currency used for the event
     * @param summary   a brief summary of the event
     * @param isPrivate the privacy status of the event (true for private, false for public)
     * @return          a new instance of an Event with the given details
     */
    Event create(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate);
}
