package interface_adapter.signup;

import entity.event.Event;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import java.util.List;

public class SignupController {
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