package data_access;

import entity.user.User;
import use_case.login.LoginUserDataAccessInterface;

public class UserDataAccessObject implements LoginUserDataAccessInterface {

    @Override
    public User get(String username) {
        return null;
    }
}
