package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventState;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyState;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventState;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.use_case.login.LoginOutputBoundary;
import com.example.eventlink.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CreateEventViewModel createEventViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final LoginViewModel loginViewModel;
    private final ModifyViewModel modifyViewModel;

    private final ViewEventViewModel viewEventViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          CreateEventViewModel createEventViewModel, LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel, ModifyViewModel modifyViewModel, ViewEventViewModel viewEventViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createEventViewModel = createEventViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.modifyViewModel = modifyViewModel;
        this.viewEventViewModel = viewEventViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        //On Success, switch to loggedInEvent view.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setName(loginOutputData.getName());
        CreateEventState createEventState = createEventViewModel.getState();
        createEventState.setUserName(loginOutputData.getName());
        ModifyState modifyState = modifyViewModel.getState();
        modifyState.setUserName(loginOutputData.getName());
        ViewEventState viewEventState = viewEventViewModel.getState();
        viewEventState.setUserName(loginOutputData.getName());
        //Sets the message to "" to clear any set messages.
        loggedInState.setMessage("");
        this.loggedInViewModel.setState(loggedInState);
        this.createEventViewModel.setState(createEventState);
        this.modifyViewModel.setState(modifyState);
        this.viewEventViewModel.setState(viewEventState);

        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        //On Fail, prepares error message to be displayed on GUI.
        LoginState loginState = loginViewModel.getState();
        loginState.setError(error);
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();
        System.out.println(error);
    }
}
