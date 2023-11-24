package com.example.eventlink.entity.event;
import com.example.eventlink.data_access.AbstractDataAccessObject;
import com.example.eventlink.data_access.EventDataAccessObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class CommonEventFactory implements EventFactory {

    @Override
    public Event create(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate) {
//        //TODO: add an actual file path
//        String filePath = "";
//        //TODO: Also address exception
//        EventDataAccessObject eventDAO = new EventDataAccessObject(filePath, this);
//
//        String id = eventDAO.save(name, start, end, currency, summary, isPrivate);
        return new CommonEvent(id, name, start, end, currency, summary, isPrivate);
    }
}
