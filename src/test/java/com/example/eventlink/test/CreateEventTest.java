package com.example.eventlink.test;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class CreateEventTest {

    private EventDataAccessObject eventDataAccessObject;
    private Event event;



    @Test
    public void testEventIdIsNotNull() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
        assertNotNull("Event ID should not be null", event.getID());

    }

    @Test
    public void testEventGetters() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
        assertEquals("Name should match", "testEvent", event.getName());
        assertEquals("Start date should match", "2024-05-12 02:00", event.getStart());
        assertEquals("End date should match", "2024-06-12 02:00", event.getEnd());
        assertEquals("Currency should match", "USD", event.getCurrency());
        assertEquals("Summary should match", "Testing Event", event.getSummary());
        assertFalse("Private flag should be false", event.getIsPrivate());
    }
}
