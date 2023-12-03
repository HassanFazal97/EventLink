/**
 * The SignupPresenter class represents the presenter responsible for handling the output
 * and interaction with the user interface during the signup action.
 */
package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginState;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.use_case.signup.SignupOutputBoundary;
import com.example.eventlink.use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary{
    /**
     * The model responsible for managing views in the application.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * The view model for managing signup-related state and data.
     */
    private final SignupViewModel signupViewModel;

    /**
     * The view model for managing login-related state and data.
     */
    private final LoginViewModel loginViewModel;

    /**
     * Constructs a new SignupPresenter with the provided dependencies.
     *
     * @param viewManagerModel The model responsible for managing views in the application.
     * @param signupViewModel  The view model for managing signup-related state and data.
     * @param loginViewModel   The view model for managing login-related state and data.
     */
    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the view for a successful signup by switching to the login view
     * and autofilling the username.
     *
     * @param user The data representing the successful signup.
     */
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

    /**
     * Prepares the view for a failed signup by displaying an error message.
     *
     * @param error The error message indicating the reason for the signup failure.
     */
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
