package com.example.eventlink.use_case.signup;

public interface SignupOutputBoundary {
    void prepareSuccessView(SignupOutputData user);

    void prepareFailView(String error);
}