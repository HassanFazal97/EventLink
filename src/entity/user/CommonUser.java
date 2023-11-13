package entity.user;

import java.util.List;
public class CommonUser implements User {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final List<String> tags;

    CommonUser(String firstName, String lastName, String username, String password, List<String> tags) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.tags = tags;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public List<String> getTags() {
        return tags;
    }
}
