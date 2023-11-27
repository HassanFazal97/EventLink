package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.use_case.signup.SignupOutputBoundary;
import com.example.eventlink.use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData user) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
