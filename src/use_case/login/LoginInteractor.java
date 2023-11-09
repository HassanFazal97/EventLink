package use_case.login;

public class LoginInteractor implements LoginInputBoundary{
    final LoginOutputBoundary loginPresenter;
    final LoginUserDataAccessInterface userDataAccessObject;

    public LoginInteractor (LoginOutputBoundary loginPresenter, LoginUserDataAccessInterface userDataAccessObject) {
        this.loginPresenter = loginPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }
    @Override
    public void execute(LoginInputData loginInputData) {

    }
}
