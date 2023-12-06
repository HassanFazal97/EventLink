/**
 * Interactor responsible for handling the registration of a user for a specific event.
 * Implements the RegisterForEventInputBoundary interface.
 */

package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.data_access.AbstractEventDataAccessObject;
import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.entity.event.Event;

import com.example.eventlink.entity.user.User;

public class RegisterForEventInteractor implements RegisterForEventInputBoundary {
    private final RegisterForEventDataAccessInterface userDataAccessObject;
    private final AbstractEventDataAccessObject eventDataAccessObject;
    private final RegisterForEventOutputBoundary eventRegistrationPresenter;

    /**
     * Constructs a RegisterForEventInteractor with the specified data access object and output presenter.
     *
     * @param userDataAccessObject       The data access object for user-related operations.
     * @param eventDataAccessObject
     * @param eventRegistrationPresenter The output presenter for event registration results.
     */
    public RegisterForEventInteractor(
            RegisterForEventDataAccessInterface userDataAccessObject,
            AbstractEventDataAccessObject eventDataAccessObject, RegisterForEventOutputBoundary eventRegistrationPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.eventDataAccessObject = eventDataAccessObject;
        this.eventRegistrationPresenter = eventRegistrationPresenter;
    }

    /**
     * Executes the registration process for a user for a specific event.
     *
     * @param registerForEventInputData The input data containing the event and the username to register.
     */
    @Override
    public void execute(RegisterForEventInputData registerForEventInputData) {
        // Find event to add to the user's list of events.
        Event event = eventDataAccessObject.get(registerForEventInputData.getEvent());
        // Find user to add the event to their list of events
        User user = userDataAccessObject.getUser(registerForEventInputData.getUsername());

        // Checks if user exists.
        if (user == null) {
            eventRegistrationPresenter.prepareFailView("We couldn't find your account.");
            return;
        }
        // Checks if the event exists.
        if (event == null) {
            eventRegistrationPresenter.prepareFailView("Sorry the event could not be found.");
            return;
        }
        String eventID = event.getID();
        String eventName = event.getName();

        // Checks if the user has already registered for this event.
        if (user.getEvents().contains(eventID)) {
            eventRegistrationPresenter.prepareFailView("You've already registered for this event.");}
        // If it passes these checks, then register the user for the event.
        else{
            user.getEvents().add(eventID);
            userDataAccessObject.updateUser(registerForEventInputData.getUsername(), user);

            RegisterForEventOutputData registerForEventOutputData = new RegisterForEventOutputData(eventName);
            eventRegistrationPresenter.prepareSuccessView(registerForEventOutputData);
        }
    }
}
