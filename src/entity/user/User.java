package entity.user;

import java.util.List;
import entity.event.Event;

public interface User {

    String getFirstName();

    String getLastName();

    String getUsername();

    String getPassword();

    List<Event> getEvents();

    List<String> getTags();
}
