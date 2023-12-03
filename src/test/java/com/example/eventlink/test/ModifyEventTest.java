package com.example.eventlink.test;

import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.user.CommonUserFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ModifyEventTest {

    private TestDataAccessObject eventDataAccessObject;
    private Event event;



//    @Test
//    public void testEventIdIsNotNull() throws IOException {
//        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
//        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
//        assertNotNull("Event ID should not be null", event.getID());
//
//    }

    @Test
    public void testEventGetters() throws IOException {
        eventDataAccessObject = new TestDataAccessObject(new CommonEventFactory(), new CommonUserFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
        String newEvent = eventDataAccessObject.modify(event.getID(), "testModifyEvent", "2025-05-12", "03:00","2025-06-12","03:00","CAD", "Testing Modify Event", true);
        assertEquals("Name should match", "testModifyEvent", event.getName());
        assertEquals("Start date should match", "2025-05-12T03:00:00Z", event.getStart());
        assertEquals("End date should match", "2025-06-12T03:00:00Z", event.getEnd());
        assertEquals("Currency should match", "CAD", event.getCurrency());
        assertEquals("Summary should match", "Testing Modify Event", event.getSummary());
        assertTrue("Private flag should be true", event.getIsPrivate());
    }
}
