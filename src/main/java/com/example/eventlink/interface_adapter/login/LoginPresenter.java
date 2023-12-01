package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.login.LoginOutputBoundary;
import com.example.eventlink.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final LoginViewModel loginViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        //On Success, switch to loggedInEvent view.
        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        //Sets the message to "" to clear any set messages.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setName(loginOutputData.getName());
        loggedInState.setMessage("");
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        //On Fail, prepares error message to be displayed on GUI.
        LoginState loginState = loginViewModel.getState();
        loginState.setError(error);
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();
        System.out.println("LP" + error);
    }
}
