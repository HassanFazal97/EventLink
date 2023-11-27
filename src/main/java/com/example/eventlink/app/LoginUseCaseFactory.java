package com.example.eventlink.app;

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
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedinViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(loginOutputBoundary,
                userDataAccessObject);

        System.out.println("Factory Initiated");
        return new LoginController(loginInteractor);
    }
}
