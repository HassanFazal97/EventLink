package entity.user;

import entity.event.Event;

import java.util.List;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String firstName, String lastName, String username, String password, List<Event> events, List<String> tags) {
        return new CommonUser(firstName, lastName, username, password, events, tags);
    }
}
