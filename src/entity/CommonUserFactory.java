package entity;

import java.util.List;

public class CommonUserFactory implements UserFactory{
    @Override
    public User create(String firstName, String lastName, String username, String password, List<String> tags) {
        return new CommonUser(firstName, lastName, username, password, tags);
    }
}
