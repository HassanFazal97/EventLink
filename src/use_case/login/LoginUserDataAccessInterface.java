package use_case.login;

import entity.user.User;

public interface LoginUserDataAccessInterface {
    User get(String username);

}
