package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupPresenter;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import com.example.eventlink.use_case.signup.SignupInputBoundary;
import com.example.eventlink.use_case.signup.SignupInteractor;
import com.example.eventlink.use_case.signup.SignupOutputBoundary;
import com.example.eventlink.use_case.signup.SignupUserDataAccessInterface;

public class SignupUseCaseFactory {
    private SignupUseCaseFactory() {}

    public static SignupController create(
            ViewManagerModel viewManagerModel,
            SignupViewModel signupViewModel,
            LoginViewModel loginViewModel,
            SignupUserDataAccessInterface userDataAccessObject) {

        //Initializes an instance of UserFactory
        UserFactory userFactory = new CommonUserFactory();
        //Initializes SignupPresenter
        SignupOutputBoundary signupPresenter = new SignupPresenter(
                viewManagerModel, signupViewModel, loginViewModel);
        //Initializes SignupInteractor
        SignupInputBoundary signupInteractor = new SignupInteractor(
                userDataAccessObject, signupPresenter, userFactory);
        //Initializes SignupController
        System.out.println("signupController Created!");
        return new SignupController(signupInteractor);
    }
}
