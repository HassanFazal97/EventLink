package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessState;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputBoundary;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputData;

/**
 * The RegisterForEventPresenter class is responsible for presenting registration results
 * to the user interface through the ViewManagerModel.
 * It implements the RegisterForEventOutputBoundary interface.
 */
public class RegisterForEventPresenter implements RegisterForEventOutputBoundary {

    private final ViewEventSuccessViewModel viewEventSuccessViewModel;
    /**
     * Constructs a RegisterForEventPresenter with the specified view manager model and view model.
     * @param viewEventSuccessViewModel The view model for representing registration details.
     */
    public RegisterForEventPresenter(ViewEventSuccessViewModel viewEventSuccessViewModel) {
        this.viewEventSuccessViewModel = viewEventSuccessViewModel;
    }

    /**
     * Prepares the success view based on the registration results.
     * @param register The output data containing information for a successful registration.
     */
    @Override
    public void prepareSuccessView(RegisterForEventOutputData register) {
        ViewEventSuccessState viewEventSuccessState = viewEventSuccessViewModel.getState();
        viewEventSuccessState.setMessage("Successfully registered for: " + register.getRegisteredEvent());
        viewEventSuccessViewModel.setState(viewEventSuccessState);
        viewEventSuccessViewModel.firePropertyChanged();
    }

    /**
     * Prepares the fail view with the specified error message.
     * @param error The error message describing the reason for the registration failure.
     */
    @Override
    public void prepareFailView(String error) {
        ViewEventSuccessState viewEventSuccessState = viewEventSuccessViewModel.getState();
        viewEventSuccessState.setMessage(error);
        viewEventSuccessViewModel.setState(viewEventSuccessState);
        viewEventSuccessViewModel.firePropertyChanged();
    }
}
