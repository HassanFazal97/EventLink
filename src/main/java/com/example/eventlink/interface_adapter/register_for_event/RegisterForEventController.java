package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.register_for_event.RegisterForEventInputBoundary;
import com.example.eventlink.use_case.register_for_event.RegisterForEventInputData;

/**
 * The RegisterForEventController class is responsible for handling registration requests
 * from the presentation layer and invoking the corresponding use case.
 * This controller takes input parameters related to event registration, creates an input data object,
 * and delegates the registration process to the specified use case interactor.
 */
public class RegisterForEventController extends Controller {

    /**
     * The use case interactor for handling event registration.
     */
    final RegisterForEventInputBoundary registerForEventUseCaseInteractor;

    /**
     * Constructs a RegisterForEventController with the specified use case interactor.
     *
     * @param registerForEventUseCaseInteractor The use case interactor for event registration.
     */
    public RegisterForEventController(RegisterForEventInputBoundary registerForEventUseCaseInteractor) {
        this.registerForEventUseCaseInteractor = registerForEventUseCaseInteractor;
    }

    /**
     * Executes the registration process for a user for a specific event.
     *
     * @param event       The ID of the event that the user is registering for.
     * @param name        The user's first name.
     * @param lastName    The user's last name.
     * @param username    The user's username.
     * @param paymentFee  The payment fee associated with the event registration.
     */
    public void execute(String event,String name, String lastName, String username, String paymentFee) {
        RegisterForEventInputData RegisterForEventInputData = new RegisterForEventInputData(
                event, name, lastName, username, paymentFee);
        registerForEventUseCaseInteractor.execute(RegisterForEventInputData);
    }

}
