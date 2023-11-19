package use_case.register_for_event;

import entity.event.Event;
import entity.event.EventFactory;
import entity.user.UserFactory;

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

        // Need to actually link events to users and users to event

        RegisterForEventOutputData registerForEventOutputData = new RegisterForEventOutputData();
        eventRegistrationPresenter.prepareSuccessView(registerForEventOutputData);
    }
}


