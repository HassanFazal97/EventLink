package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginState;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.use_case.signup.SignupOutputBoundary;
import com.example.eventlink.use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary{
    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData user) {
        //On Success, switch to loginView, set username to username
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        //Autofill the username of the newly created account in loginView.
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(user.getUsername());
        loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        //On Fail, prepares an error message to be displayed on GUI.
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        this.signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
        System.out.println(error);
    }
}
