package use_case.signup;
import entity.user.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String username);

    void save(User user);
}
