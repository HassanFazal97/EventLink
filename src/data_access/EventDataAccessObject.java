package data_access;

import entity.event.Event;
import entity.event.EventFactory;
import use_case.modify_events.ModifyEventDataAccessInterface;
import use_case.create_events.CreateEventDataAccessInterface;
import use_case.register_for_event.RegisterForEventDataAccessInterface;
import use_case.view_event.ViewEventDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class EventDataAccessObject implements ViewEventDataAccessInterface,
        ModifyEventDataAccessInterface, CreateEventDataAccessInterface,
        RegisterForEventDataAccessInterface {


    private final Map<String, Event> events = new HashMap<String, Event>();

    private EventFactory eventFactory;

    public EventDataAccessObject(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }
    @Override
    public Event get(String id) {
        return events.get(id);
    }

    @Override
    public boolean existsById(String id) {
        return events.containsKey(id);
    }

    @Override
    public void save(Event event) {
        events.put(event.getID(), event);
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getID());
    }
}
