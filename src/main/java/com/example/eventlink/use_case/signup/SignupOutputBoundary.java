/**
 * The SignupOutputBoundary interface defines the outline for the presenter responsible for handling the output
 * and interaction with the user interface during the signup action.
 */
package com.example.eventlink.use_case.signup;

public interface SignupOutputBoundary {

    /**
     * Prepares the view for a successful signup by passing the signup output data.
     *
     * @param user The data representing the successful signup of the user.
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares the view for a failed signup by passing an error message.
     *
     * @param error The error message indicating the reason for the signup failure.
     */
    void prepareFailView(String error);
}