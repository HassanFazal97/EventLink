package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.use_case.modify_events.ModifyOutputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyOutputData;

public class ModifyPresenter implements ModifyOutputBoundary {
    private final ModifyViewModel modifyViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final GuestViewModel guestViewModel;
    private final ViewManagerModel viewManagerModel;

    public ModifyPresenter(ModifyViewModel modifyViewModel, LoggedInViewModel loggedInViewModel,
                           GuestViewModel guestViewModel, ViewManagerModel viewManagerModel) {
        this.modifyViewModel = modifyViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.guestViewModel = guestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ModifyOutputData outputData) {
        String SUCCESS_MESSAGE = "Successfully modified event: ";
        //On Success, update loggedInEvent view with a success message and switch to it.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEvents(outputData.getEvents());
        loggedInState.setMessage(SUCCESS_MESSAGE + outputData.getEventName());
        this.loggedInViewModel.setState(loggedInState);

        GuestState guestState = guestViewModel.getState();
        guestState.setEvents(outputData.getEvents());
        this.guestViewModel.setState(guestState);

        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        //On Fail, prepare an error message to be displayed on GUI.
        ModifyState modifyState = modifyViewModel.getState();
        modifyState.setError(error);
        modifyViewModel.setState(modifyState);
        modifyViewModel.firePropertyChanged();
    }
}
