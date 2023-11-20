package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputBoundary;
import com.example.eventlink.use_case.register_for_event.RegisterForEventOutputData;

public class RegisterForEventPresenter implements RegisterForEventOutputBoundary {

    private final RegisterForEventViewModel registerForEventViewModelViewModel;
    private final ViewManagerModel viewManagerModel;


    public RegisterForEventPresenter(ViewManagerModel viewManagerModel,
                                     RegisterForEventViewModel registerForEventViewModel) {
        this.registerForEventViewModelViewModel = registerForEventViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RegisterForEventOutputData register) {
    }

    @Override
    public void prepareFailView(String error) {
    }
}
