package com.example.eventlink.test;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;

import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventController;
import com.example.eventlink.interface_adapter.create_events.CreateEventPresenter;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.create_events.CreateEventInteractor;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CreateEventTest {

    private TestDataAccessObject eventDataAccessObject;
    private Event event;
    @Test
    public void testCreateSuccess() throws IOException {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory);
        CreateEventViewModel viewModel = new CreateEventViewModel();
        CreateEventPresenter presenter = new CreateEventPresenter(new ViewManagerModel(), viewModel, new LoggedInViewModel(), new GuestViewModel());
        CreateEventController controller = new CreateEventController(new CreateEventInteractor(eventDataAccessObject, presenter, factory));
        List<Event> events = eventDataAccessObject.getAllEvents();
        controller.execute("testCreateEvent", "2025-05-12", "03:00","2025-06-12","03:00","CAD", "Testing Create Event", true);
        Event event = null;
        for (Event e: eventDataAccessObject.getAllEvents()) {
            if (!events.contains(e)) {
                event = e;
            }
        }
        assertNotEquals("Event could not be retrieved post-creation", null, event);
        assertEquals("Name should match", "testCreateEvent", event.getName());
        assertEquals("Start date should match", "2025-05-12 03:00", event.getStart());
        assertEquals("End date should match", "2025-06-12 03:00", event.getEnd());
        assertEquals("Currency should match", "CAD", event.getCurrency());
        assertEquals("Summary should match", "Testing Create Event", event.getSummary());
        assertTrue("Private flag should be true", event.getIsPrivate());
        assertEquals("There should be no error in ViewModel", "", viewModel.getState().getError());
    }

    @Test
    public void testCreateFail() throws IOException {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory);
        CreateEventViewModel viewModel = new CreateEventViewModel();
        CreateEventPresenter presenter = new CreateEventPresenter(new ViewManagerModel(), viewModel, new LoggedInViewModel(), new GuestViewModel());
        CreateEventController controller = new CreateEventController(new CreateEventInteractor(eventDataAccessObject, presenter, factory));
        List<Event> events = eventDataAccessObject.getAllEvents();
        controller.execute("", "2025-05-12", "03:00","2025-06-12","03:00","CAD", "Testing Create Event", true);
        Event event = null;
        for (Event e: eventDataAccessObject.getAllEvents()) {
            if (!events.contains(e)) {
                event = e;
            }
        }
        assertEquals("Non-existent event was retrieved", null, event);
        assertEquals("Error not correctly described in ViewModel", "Exception raised during data storage procedures", viewModel.getState().getError());
    }

//    @Test


//    @Test
//    public void testEventIdIsNotNull() throws IOException {
//        eventDataAccessObject = new TestDataAccessObject(new CommonEventFactory());
//        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
//        assertNotNull("Event ID should not be null", event.getID());
//
//    }
//
//    @Test
//    public void testEventGetters() throws IOException {
//        eventDataAccessObject = new TestDataAccessObject(new CommonEventFactory());
//        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
//        assertEquals("Name should match", "testEvent", event.getName());
//        assertEquals("Start date should match", "2024-05-12 02:00", event.getStart());
//        assertEquals("End date should match", "2024-06-12 02:00", event.getEnd());
//        assertEquals("Currency should match", "USD", event.getCurrency());
//        assertEquals("Summary should match", "Testing Event", event.getSummary());
//        assertFalse("Private flag should be false", event.getIsPrivate());
//    }
}
