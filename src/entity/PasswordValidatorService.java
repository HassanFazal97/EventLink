package entity;

public class PasswordValidatorService implements PasswordValidator{
    @Override
    public boolean passwordIsValid(String password) {
        return password != null && password.length() >= 6;
    }
}
