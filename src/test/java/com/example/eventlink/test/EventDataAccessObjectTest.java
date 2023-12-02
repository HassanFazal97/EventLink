package com.example.eventlink.test;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;

public class EventDataAccessObjectTest {

    private EventDataAccessObject eventDataAccessObject;
    private Event event;



    @Test
    public void testEventIdIsNotNull() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertNotNull("Event ID should not be null", event.getID());

    }

    @Test
    public void testEventGetters() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertEquals("Name should match", "testEvent", event.getName());
        assertEquals("Start date should match", "2024-05-12T02:00:00Z", event.getStart());
        assertEquals("End date should match", "2025-05-12T02:00:00Z", event.getEnd());
        assertEquals("Currency should match", "USD", event.getCurrency());
        assertEquals("Summary should match", "Testing Event", event.getSummary());
        assertFalse("Private flag should be false", event.getIsPrivate());
    }

    @Test
    public void testMemoryMatchesFile() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test.csv"))) {
            String header = reader.readLine();
            assertEquals("Header is missing", "name,start,end,currency,summary,isPrivate,id", header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                assertEquals("Name should match", info[0], event.getName());
                assertEquals("Start date should match", info[1], event.getStart());
                assertEquals("End date should match", info[2], event.getEnd());
                assertEquals("Currency should match", info[3], event.getCurrency());
                assertEquals("Summary should match", info[4], event.getSummary());
                assertEquals("Private flag should match", info[5], String.valueOf(event.getIsPrivate()));

            }
        }
    }

}
