package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.use_case.login.LoginOutputBoundary;
import com.example.eventlink.use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
