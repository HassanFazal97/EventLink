package com.example.eventlink.use_case.signup;

import com.example.eventlink.entity.PasswordValidator;
import com.example.eventlink.entity.PasswordValidatorService;
import com.example.eventlink.entity.user.User;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.entity.event.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        PasswordValidator passwordValidator = new PasswordValidatorService();

        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else if (!passwordValidator.passwordIsValid(signupInputData.getPassword())) {
            userPresenter.prepareFailView("Password is invalid. Password should be at least 6 chars long.");
        } else {

            LocalDateTime now = LocalDateTime.now();

            List<Event> events = new ArrayList<>();

            User user = userFactory.create(signupInputData.getFirstName(), signupInputData.getLastName(),
                    signupInputData.getUsername(), signupInputData.getPassword(), events, signupInputData.getTags());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}