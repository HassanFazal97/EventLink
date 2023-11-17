package use_case.modify_events;
import entity.event.Event;

public interface ModifyUserDataAccessInterface {

    boolean existsById(String id);

    void save(Event event);

}
