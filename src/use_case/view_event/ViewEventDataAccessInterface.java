package use_case.view_event;

import entity.event.Event;

public interface ViewEventDataAccessInterface {
    Event get(String id);
}
