package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.entity.user.CommonUser;
import com.example.eventlink.entity.user.UserFactory;

public class RegisterForEventInteractor implements RegisterForEventInputBoundary {
    private final RegisterForEventDataAccessInterface eventDataAccessObject;
    private final RegisterForEventOutputBoundary eventRegistrationPresenter;
    private final UserFactory userFactory;
    private final EventFactory eventFactory;

    public RegisterForEventInteractor(
            RegisterForEventDataAccessInterface eventDataAccessObject,
            RegisterForEventOutputBoundary eventRegistrationPresenter,
            UserFactory userFactory, EventFactory eventFactory) {
        this.eventDataAccessObject = eventDataAccessObject;
        this.eventRegistrationPresenter = eventRegistrationPresenter;
        this.userFactory = userFactory;
        this.eventFactory = eventFactory;
    }

    @Override
    public void execute(RegisterForEventInputData registerForEventInputData) {
        Event event = registerForEventInputData.getEvent();
        String name = registerForEventInputData.getName();
        String lastName = registerForEventInputData.getLastName();
        String username = registerForEventInputData.getUsername();
        String paymentFee = registerForEventInputData.getPaymentFee();

        // Find user to add the event to their list of event
        CommonUser commonUser = eventDataAccessObject.getUsername(username);

        // Check if the user exists
        if (commonUser != null) {
            // Add the event to the user's list of events
            commonUser.getEvents().add(event);

            // Update the user in the data access object
            eventDataAccessObject.UpdateUser(commonUser);

            // Prepare success view since user was found
            RegisterForEventOutputData registerForEventOutputData = new RegisterForEventOutputData();
            eventRegistrationPresenter.prepareSuccessView(registerForEventOutputData);

        } else {
            // User not found, handle accordingly by preparing fail view
            eventRegistrationPresenter.prepareFailView("User not found");

        }
    }
}


