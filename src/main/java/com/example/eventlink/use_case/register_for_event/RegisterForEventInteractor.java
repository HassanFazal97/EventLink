package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.event.Event;

import com.example.eventlink.entity.user.User;

/**
 * Interactor responsible for handling the registration of a user for a specific event.
 * Implements the RegisterForEventInputBoundary interface.
 */
public class RegisterForEventInteractor implements RegisterForEventInputBoundary {
    private final RegisterForEventDataAccessInterface userDataAccessObject;
    private final RegisterForEventOutputBoundary eventRegistrationPresenter;

    /**
     * Constructs a RegisterForEventInteractor with the specified data access object and output presenter.
     *
     * @param userDataAccessObject      The data access object for user-related operations.
     * @param eventRegistrationPresenter The output presenter for event registration results.
     */
    public RegisterForEventInteractor(
            RegisterForEventDataAccessInterface userDataAccessObject,
            RegisterForEventOutputBoundary eventRegistrationPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.eventRegistrationPresenter = eventRegistrationPresenter;
    }

    /**
     * Executes the registration process for a user for a specific event.
     *
     * @param registerForEventInputData The input data containing the event and the username to register.
     */
    @Override
    public void execute(RegisterForEventInputData registerForEventInputData) {
        Event event = registerForEventInputData.getEvent();
        String username = registerForEventInputData.getUsername();

        // Find user to add the event to their list of event
        User user = userDataAccessObject.getUsername(username);

        // Check if the user exists
        if (user != null) {
            // Add the event to the user's list of events
            user.getEvents().add(event);

            // Update the user in the data access object
            userDataAccessObject.UpdateUser(user);

            // Prepare success view since user was found
            RegisterForEventOutputData registerForEventOutputData = new RegisterForEventOutputData();
            eventRegistrationPresenter.prepareSuccessView(registerForEventOutputData);

        } else {
            // User not found, handle accordingly by preparing fail view
            eventRegistrationPresenter.prepareFailView("User not found");

        }
    }
}
