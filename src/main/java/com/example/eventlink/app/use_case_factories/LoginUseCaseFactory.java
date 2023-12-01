package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginPresenter;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventController;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventViewModel;
import com.example.eventlink.use_case.login.LoginInputBoundary;
import com.example.eventlink.use_case.login.LoginInteractor;
import com.example.eventlink.use_case.login.LoginOutputBoundary;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory() {}

    public static LoginController create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedinViewModel,
            CreateEventViewModel createEventViewModel,
            ModifyViewModel modifyViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        //Intializes LoginPresenter
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                createEventViewModel, loggedinViewModel, loginViewModel, modifyViewModel);
        //Initializes LoginInteractor
        LoginInputBoundary loginInteractor = new LoginInteractor(loginOutputBoundary,
                userDataAccessObject);
        //Initializes LoginController
        System.out.println("loginController Created!");
        return new LoginController(loginInteractor);
    }
}
