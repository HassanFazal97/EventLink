package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginPresenter;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.use_case.login.LoginInputBoundary;
import com.example.eventlink.use_case.login.LoginInteractor;
import com.example.eventlink.use_case.login.LoginOutputBoundary;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;
import com.example.eventlink.view.LoginViewController;
import com.example.eventlink.view.ViewManager;

import javax.swing.text.View;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory() {}

    public static LoginController create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedinViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        //Intializes LoginPresenter
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedinViewModel, loginViewModel);
        //Initializes LoginInteractor
        LoginInputBoundary loginInteractor = new LoginInteractor(loginOutputBoundary,
                userDataAccessObject);
        //Initializes LoginController
        System.out.println("loginController Created!");
        return new LoginController(loginInteractor);
    }
}
