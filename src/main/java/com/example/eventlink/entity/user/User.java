package com.example.eventlink.entity.user;

import java.util.List;
import com.example.eventlink.entity.event.Event;

public interface User {

    String getFirstName();

    String getLastName();

    String getUsername();

    String getPassword();

    List<String> getEvents();

    List<String> getTags();
}
