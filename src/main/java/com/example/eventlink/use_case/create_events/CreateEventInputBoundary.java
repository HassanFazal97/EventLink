package com.example.eventlink.use_case.create_events;

/**
 * Interface for the input boundary of creating an event.
 * This interface defines the method for executing the event creation process.
 */
public interface CreateEventInputBoundary {

    /**
     * Executes the event creation process with the provided input data.
     *
     * @param createEventInputData the data required to create a new event
     */
    void execute(CreateEventInputData createEventInputData);
}
