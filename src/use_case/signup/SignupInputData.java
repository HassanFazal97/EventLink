package use_case.signup;
import entity.event.Event;

import java.util.List;

public class SignupInputData {
    final private String username;
    final private String password;
    final private String repeatPassword;

    final private String firstName;
    final private String lastName;
    final private List<String> tags;

    public SignupInputData(String username, String password, String repeatPassword,
                           String firstName, String lastName, List<String> tags) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tags = tags;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() { return repeatPassword; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getTags() {
        return tags;
    }
}
