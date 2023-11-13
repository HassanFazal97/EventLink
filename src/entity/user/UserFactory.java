package entity.user;

import entity.event.Event;
import entity.user.User;

import java.util.List;
public interface UserFactory {
    User create(String firstName, String lastName, String username, String password, List<Event> events, List<String> tags);
}
