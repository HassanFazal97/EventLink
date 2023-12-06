package com.example.eventlink.test;

import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.entity.user.User;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventController;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventPresenter;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.register_for_event.RegisterForEventInteractor;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class RegisterTest {

    private TestDataAccessObject dataAccessObject;
    private User user;

    @Test
    public void testRegisterSuccess() throws IOException {
        EventFactory eventFactory = new CommonEventFactory();
        UserFactory userFactory = new CommonUserFactory();
        dataAccessObject = new TestDataAccessObject(eventFactory);
        user = userFactory.create("test", "name", "testName", "1111", new ArrayList<>(), new ArrayList<>());
        dataAccessObject.save(user);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        RegisterForEventPresenter presenter = new RegisterForEventPresenter(viewModel);
        RegisterForEventInteractor interactor = new RegisterForEventInteractor(dataAccessObject, dataAccessObject, presenter);
        RegisterForEventController controller = new RegisterForEventController(interactor);
        Event event = dataAccessObject.create("testRegistration", "2024-07-12", "02:30", "2024-08-12","02:45","USD", "Testing Registration", false);
        controller.execute(event.getID(), user.getFirstName(), user.getLastName(), user.getUsername(), "5.00");
        assertTrue("User was not registered for the event", user.getEvents().contains(event.getID()));
        assertEquals("There should be no error in ViewModel", "Successfully registered for: testRegistration", viewModel.getState().getMessage());
    }

    @Test
    public void testRegisterFailNonexistentUser() throws IOException {
        EventFactory eventFactory = new CommonEventFactory();
        dataAccessObject = new TestDataAccessObject(eventFactory);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        RegisterForEventPresenter presenter = new RegisterForEventPresenter(viewModel);
        RegisterForEventInteractor interactor = new RegisterForEventInteractor(dataAccessObject, dataAccessObject, presenter);
        RegisterForEventController controller = new RegisterForEventController(interactor);
        Event event = dataAccessObject.create("testRegistration", "2024-07-12", "02:30", "2024-08-12","02:45","USD", "Testing Registration", false);
        controller.execute(event.getID(), "fake", "user", "notReal", "6.00");
        assertFalse("Nonexistent user was found", dataAccessObject.existsByName("notReal"));
        assertEquals("Error not correctly described in ViewModel", "We couldn't find your account.", viewModel.getState().getMessage());
    }

    @Test
    public void testRegisterFailNonexistentEvent() throws IOException {
        EventFactory eventFactory = new CommonEventFactory();
        UserFactory userFactory = new CommonUserFactory();
        dataAccessObject = new TestDataAccessObject(eventFactory);
        user = userFactory.create("test", "name", "testName", "1111", new ArrayList<>(), new ArrayList<>());
        dataAccessObject.save(user);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        RegisterForEventPresenter presenter = new RegisterForEventPresenter(viewModel);
        RegisterForEventInteractor interactor = new RegisterForEventInteractor(dataAccessObject, dataAccessObject, presenter);
        RegisterForEventController controller = new RegisterForEventController(interactor);
        controller.execute("-1", user.getFirstName(), user.getLastName(), user.getUsername(), "5.00");
        assertFalse("Nonexistent event was found", dataAccessObject.existsById("-1"));
        assertEquals("Error not correctly described in ViewModel", "Sorry the event could not be found.", viewModel.getState().getMessage());
    }

    @Test
    public void testRegisterFailAlreadyRegistered() throws IOException {
        EventFactory eventFactory = new CommonEventFactory();
        UserFactory userFactory = new CommonUserFactory();
        dataAccessObject = new TestDataAccessObject(eventFactory);
        user = userFactory.create("test", "name", "testName", "1111", new ArrayList<>(), new ArrayList<>());
        dataAccessObject.save(user);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        RegisterForEventPresenter presenter = new RegisterForEventPresenter(viewModel);
        RegisterForEventInteractor interactor = new RegisterForEventInteractor(dataAccessObject, dataAccessObject, presenter);
        RegisterForEventController controller = new RegisterForEventController(interactor);
        Event event = dataAccessObject.create("testRegistration", "2024-07-12", "02:30", "2024-08-12","02:45","USD", "Testing Registration", false);
        controller.execute(event.getID(), user.getFirstName(), user.getLastName(), user.getUsername(), "5.00");
        assertTrue("User was not registered for the event", user.getEvents().contains(event.getID()));
        List<String> events = user.getEvents();
        controller.execute(event.getID(), user.getFirstName(), user.getLastName(), user.getUsername(), "5.00");
        assertEquals("Event registration status was changed during duplicate registration", events, user.getEvents());
        assertEquals("Error not correctly described in ViewModel", "You've already registered for this event.", viewModel.getState().getMessage());
    }

}
