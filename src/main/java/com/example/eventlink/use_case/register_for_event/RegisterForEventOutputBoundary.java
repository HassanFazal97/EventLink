package com.example.eventlink.use_case.register_for_event;

/**
 * The RegisterForEventOutputBoundary interface defines methods for preparing views
 * in response to the registration results of the RegisterForEvent use case.
 */
public interface RegisterForEventOutputBoundary {
    /**
     * Prepares a success view based on the registration results.
     *
     * @param register The output data containing information for a successful registration.
     */
    void prepareSuccessView(RegisterForEventOutputData register);

    /**
     * Prepares a fail view with the specified error message.
     *
     * @param error The error message describing the reason for the registration failure.
     */
    void prepareFailView(String error);
}
