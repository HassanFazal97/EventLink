package com.example.eventlink.use_case.modify_events;
import com.example.eventlink.entity.event.Event;

public interface ModifyUserDataAccessInterface {

    boolean existsById(String id);

    void save(Event event);

}
