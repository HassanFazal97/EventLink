package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputBoundary;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputData;

/**
 * The RegisterForEventPresenter class is responsible for presenting registration results
 * to the user interface through the ViewManagerModel.
 * It implements the RegisterForEventOutputBoundary interface.
 */
public class RegisterForEventPresenter implements RegisterForEventOutputBoundary {

    /**
     * The view model responsible for representing the registration details in the user interface.
     */
    private final RegisterForEventViewModel registerForEventViewModelViewModel;

    /**
     * The model responsible for managing views in the user interface.
     */
    private final ViewManagerModel viewManagerModel;


    /**
     * Constructs a RegisterForEventPresenter with the specified view manager model and view model.
     *
     * @param viewManagerModel              The model for managing views in the user interface.
     * @param registerForEventViewModel     The view model for representing registration details.
     */
    public RegisterForEventPresenter(ViewManagerModel viewManagerModel,
                                     RegisterForEventViewModel registerForEventViewModel) {
        this.registerForEventViewModelViewModel = registerForEventViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view based on the registration results.
     *
     * @param register The output data containing information for a successful registration.
     */
    @Override
    public void prepareSuccessView(RegisterForEventOutputData register) {
    }

    /**
     * Prepares the fail view with the specified error message.
     *
     * @param error The error message describing the reason for the registration failure.
     */
    @Override
    public void prepareFailView(String error) {
    }
}
