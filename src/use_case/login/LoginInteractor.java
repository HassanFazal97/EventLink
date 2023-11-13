package use_case.login;

import entity.user.User;

public class LoginInteractor implements LoginInputBoundary{
    final LoginOutputBoundary loginPresenter;
    final LoginUserDataAccessInterface userDataAccessObject;

    public LoginInteractor (LoginOutputBoundary loginPresenter, LoginUserDataAccessInterface userDataAccessObject) {
        this.loginPresenter = loginPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        try {
            User user = userDataAccessObject.get(username);
            String stored_password = user.getPassword();

            if(!password.equals(stored_password)) {
                loginPresenter.prepareFailView("Password incorrect for " + username);
            }
            else {
                LoginOutputData loginOutputData = new LoginOutputData(user.getFirstName(), user.getLastName());
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
        catch(Exception e) {
            loginPresenter.prepareFailView(username + " does not exist");
        }
    }
}
