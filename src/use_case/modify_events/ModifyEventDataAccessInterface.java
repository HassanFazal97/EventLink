package use_case.modify_events;
import entity.event.Event;

public interface ModifyEventDataAccessInterface {

    boolean existsById(String id);

    void save(Event event);

    void remove(Event event);

}
