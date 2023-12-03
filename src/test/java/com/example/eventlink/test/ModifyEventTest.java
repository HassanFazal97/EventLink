package com.example.eventlink.test;

import com.example.eventlink.data_access.AbstractEventDataAccessObject;
import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.modify_events.ModifyState;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyController;
import com.example.eventlink.interface_adapter.modify_events.ModifyPresenter;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.use_case.modify_events.ModifyInteractor;
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
    public void testEventGetters() {
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

    @Test
    public void testModifySuccess() {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory, new CommonUserFactory());
        Event event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
        ModifyViewModel viewModel = new ModifyViewModel();
        ModifyPresenter presenter = new ModifyPresenter(viewModel, new LoginViewModel(), new ViewManagerModel());
        ModifyController controller = new ModifyController(new ModifyInteractor(eventDataAccessObject, presenter, factory));
        controller.execute(event.getID(), "testModifyEvent", "2025-05-12", "03:00","2025-06-12","03:00","CAD", "Testing Modify Event", true);
        assertTrue("Event could not be retrieved post-modification", eventDataAccessObject.existsById(event.getID()));
        Event newEvent = eventDataAccessObject.get(event.getID());
        assertEquals("Name should match", "testModifyEvent", newEvent.getName());
        assertEquals("Start date should match", "2025-05-12T03:00:00Z", newEvent.getStart());
        assertEquals("End date should match", "2025-06-12T03:00:00Z", newEvent.getEnd());
        assertEquals("Currency should match", "CAD", newEvent.getCurrency());
        assertEquals("Summary should match", "Testing Modify Event", newEvent.getSummary());
        assertTrue("Private flag should be true", newEvent.getIsPrivate());
        assertEquals("There should be no error in ViewModel", "", viewModel.getState().getError());
    }

    @Test
    public void testModifyFailNotFound() {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory, new CommonUserFactory());
        ModifyViewModel viewModel = new ModifyViewModel();
        ModifyPresenter presenter = new ModifyPresenter(viewModel, new LoginViewModel(), new ViewManagerModel());
        ModifyController controller = new ModifyController(new ModifyInteractor(eventDataAccessObject, presenter, factory));
        controller.execute("-1", "testModifyEvent", "2025-05-12", "03:00","2025-06-12","03:00","CAD", "Testing Modify Event", true);
        assertFalse("Non-existing event was somehow retrieved", eventDataAccessObject.existsById("-1"));
        assertEquals("Error not correctly described in ViewModel", "Event not found.", viewModel.getState().getError());
    }

}
