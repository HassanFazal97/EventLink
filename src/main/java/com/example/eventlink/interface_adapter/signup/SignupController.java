package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.signup.SignupInputBoundary;
import com.example.eventlink.use_case.signup.SignupInputData;

import java.util.List;

public class SignupController extends Controller {
    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2,
                        String firstName, String lastName, List<String> tags) {

        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, firstName, lastName, tags);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}