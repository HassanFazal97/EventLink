/**
 * The SignupController class represents the controller responsible for handling signup-related requests
 * and interacting with the signup use case.
 */
package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.signup.SignupInputBoundary;
import com.example.eventlink.use_case.signup.SignupInputData;

import java.util.List;

public class SignupController extends Controller {

    /**
     * The signup use case interactor responsible for executing the signup process.
     */
    final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Constructs a new SignupController with the provided signup use case interactor.
     *
     * @param userSignupUseCaseInteractor The signup use case interactor.
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the signup process with the provided user information.
     *
     * @param username   The chosen username for signup.
     * @param password1  The chosen password for signup.
     * @param password2  The repeated password for confirmation.
     * @param firstName  The first name of the user.
     * @param lastName   The last name of the user.
     * @param tags       A list of tags associated with the user.
     */
    public void execute(String username, String password1, String password2,
                        String firstName, String lastName, List<String> tags) {

        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, firstName, lastName, tags);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}