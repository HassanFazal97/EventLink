package entity;

import java.util.List;
public interface UserFactory {
    User create(String firstName, String lastName, String username, String password, List<String> tags);
}
