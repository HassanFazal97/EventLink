package com.example.eventlink.test;

import com.example.eventlink.data_access.AbstractEventDataAccessObject;
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

    private AbstractEventDataAccessObject eventDataAccessObject;
    private Event event;

    @Test
    public void testEventIdIsNotNull() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertNotNull("Event ID should not be null", event.getID());

    }

    @Test
    public void testEventGetters() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertEquals("Name should match", "testEvent", event.getName());
        assertEquals("Start date should match", "2024-05-12 02:00", event.getStart());
        assertEquals("End date should match", "2025-05-12 02:00", event.getEnd());
        assertEquals("Currency should match", "USD", event.getCurrency());
        assertEquals("Summary should match", "Testing Event", event.getSummary());
        assertFalse("Private flag should be false", event.getIsPrivate());
    }

    @Test
    public void testMemoryMatchesFile() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test.csv"))) {
            String header = reader.readLine();
            assertEquals("Header is missing", "name,start,end,currency,summary,isPrivate,id", header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                String id = info[6];
                event = eventDataAccessObject.get(id);
                assertEquals("Name should match", event.getName(), info[0]);
                assertEquals("Start date should match", event.getStart(), info[1]);
                assertEquals("End date should match", event.getEnd(), info[2]);
                assertEquals("Currency should match", event.getCurrency(), info[3]);
                assertEquals("Summary should match", event.getSummary(), info[4]);
                assertEquals("Private flag should match", String.valueOf(event.getIsPrivate()), info[5]);
            }
        }
    }
    @Test
    public void testExistsByIdPass() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertTrue("Event could not be found", eventDataAccessObject.existsById(event.getID()));
    }

    @Test
    public void testExistsByIdFail() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        assertFalse("Nonexistent event was found", eventDataAccessObject.existsById("0"));
    }

    @Test
    public void testEventDAOGetter() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        assertEquals("Retrieved event does not match created event", eventDataAccessObject.get(event.getID()), event);
    }

    @Test
    public void testEventDeletion() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        String id = event.getID();
        eventDataAccessObject.remove(id);
        assertFalse("Event was not properly deleted from the system", eventDataAccessObject.existsById(id));
    }
    @Test
    public void testEventModification() throws IOException {
        eventDataAccessObject = new EventDataAccessObject("src/test.csv", new CommonEventFactory());
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2025-05-12", "02:00", "USD", "Testing Event", false);
        String id = eventDataAccessObject.modify(event.getID(), "testChanged", "2024-06-17", "03:00", "2025-06-17", "06:00", "CAD", "Testing Event Changes", true);
        assertEquals("ID is not consistent between new and old version of event", event.getID(), id);
        assertEquals("Name was not modified", "testChanged", event.getName());
        assertEquals("Start date was not modified", "2024-06-17 03:00", event.getStart());
        assertEquals("End date was not modified", "2025-06-17 06:00", event.getEnd());
        assertEquals("Currency was not modified", "CAD", event.getCurrency());
        assertEquals("Summary was not modified", "Testing Event Changes", event.getSummary());
        assertTrue("Private flag was not modified", event.getIsPrivate());
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test.csv"))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                if (info[6].equals(id)) {
                    assertEquals("New name was not written to file", "testChanged", info[0]);
                    assertEquals("New start date was not written to file", "2024-06-17 03:00", info[1]);
                    assertEquals("New end date was not written to file", "2025-06-17 06:00", info[2]);
                    assertEquals("New currency was not written to file", "CAD", info[3]);
                    assertEquals("New summary was not written to file", "Testing Event Changes", info[4]);
                    assertTrue("New private flag was not written to file", Boolean.parseBoolean(info[5]));

                }
            }
        }
    }
}
