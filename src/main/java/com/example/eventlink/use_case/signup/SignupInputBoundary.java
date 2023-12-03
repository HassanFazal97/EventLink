/**
 * The SignupInputBoundary interface defines the outline for the signup use case interactor.
 * The interactor should provide logic for executing the signup operation by accepting the necessary input data.
 */
package com.example.eventlink.use_case.signup;

public interface SignupInputBoundary {
    /**
     * Executes the signup process with the provided signup input data.
     *
     * @param signupInputData The data containing necessary information for the signup action.
     */
    void execute(SignupInputData signupInputData);
}
