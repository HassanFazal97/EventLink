/**
 * The SignupInteractor class represents the interactor responsible for handling the signup use case.
 * It interacts with data access objects, validators, presenters, and user factory to execute the signup process.
 */
package com.example.eventlink.use_case.signup;

import com.example.eventlink.entity.PasswordValidator;
import com.example.eventlink.entity.PasswordValidatorService;
import com.example.eventlink.entity.user.User;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.entity.event.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SignupInteractor implements SignupInputBoundary {

    /**
     * The data access object for user-related operations.
     */
    final SignupUserDataAccessInterface userDataAccessObject;

    /**
     * The presenter for handling output and interaction with the user interface.
     */
    final SignupOutputBoundary userPresenter;

    /**
     * The factory for creating user entities.
     */
    final UserFactory userFactory;

    /**
     * Constructs a new SignupInteractor with the provided dependencies.
     *
     * @param signupDataAccessInterface The data access object for user-related operations.
     * @param signupOutputBoundary      The presenter for handling output and interaction with the user interface.
     * @param userFactory               The factory for creating user entities.
     */
    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    /**
     * Executes the signup process with the provided signup input data.
     *
     * @param signupInputData The data containing necessary information for the signup operation.
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        PasswordValidator passwordValidator = new PasswordValidatorService();

        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else if (!passwordValidator.passwordIsValid(signupInputData.getPassword())) {
            userPresenter.prepareFailView("Password is invalid. Password should be at least 6 chars long.");
        } else {

            LocalDateTime now = LocalDateTime.now();

            List<Event> events = new ArrayList<>();

            User user = userFactory.create(signupInputData.getFirstName(), signupInputData.getLastName(),
                    signupInputData.getUsername(), signupInputData.getPassword(), events, signupInputData.getTags());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}
