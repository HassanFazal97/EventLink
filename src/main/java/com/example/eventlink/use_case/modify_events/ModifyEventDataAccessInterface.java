package com.example.eventlink.use_case.modify_events;
import com.example.eventlink.entity.event.Event;

public interface ModifyEventDataAccessInterface {

    boolean existsById(String id);

    String modify(String id, String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);

    void remove(String id);

}
