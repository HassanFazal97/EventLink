package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.UserDataAccessObject;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventController;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventPresenter;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.register_for_event.RegisterForEventDataAccessInterface;
import com.example.eventlink.use_case.register_for_event.RegisterForEventInputBoundary;
import com.example.eventlink.use_case.register_for_event.RegisterForEventInteractor;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputBoundary;

public class RegisterForEventUseCaseFactory {
    private RegisterForEventUseCaseFactory() {}

    public static RegisterForEventController create(
            ViewEventSuccessViewModel viewEventSuccessViewModel,
            UserDataAccessObject userDataAccessObject,
            EventDataAccessObject eventDataAccessObject) {
        RegisterForEventOutputBoundary registerForEventPresenter = new
                RegisterForEventPresenter(viewEventSuccessViewModel);

        RegisterForEventInputBoundary registerForEventInteractor = new RegisterForEventInteractor(
                userDataAccessObject, eventDataAccessObject, registerForEventPresenter);

        return new RegisterForEventController(registerForEventInteractor);
    }
}
