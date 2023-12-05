package com.example.eventlink.use_case.create_events;

/**
 * Interface for the output boundary of creating an event.
 * This interface defines the methods for preparing the views in case of success or failure
 * of the event creation process.
 */
public interface CreateEventOutputBoundary {

    /**
     * Prepares the view for a successful event creation.
     * This method is called when an event is successfully created.
     *
     * @param event the output data of the successfully created event
     */
    void prepareSuccessView(CreateEventOutputData event);

    /**
     * Prepares the view for a failed event creation.
     * This method is called when the event creation process encounters an error.
     *
     * @param error the error message describing why the event creation failed
     */
    void prepareFailView(String error);
}
