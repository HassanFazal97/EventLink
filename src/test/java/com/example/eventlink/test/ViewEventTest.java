package com.example.eventlink.test;

import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventController;
import com.example.eventlink.interface_adapter.view_event.ViewEventPresenter;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.view_event.ViewEventInteractor;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
public class ViewEventTest {

    private TestDataAccessObject eventDataAccessObject;

    private Event event;

    @Test
    public void testViewSuccess() throws IOException {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory);
        event = eventDataAccessObject.create("testEvent", "2024-05-12", "02:00", "2024-06-12","02:00","USD", "Testing Event", false);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        ViewEventPresenter presenter = new ViewEventPresenter(new ViewManagerModel(), viewModel);
        ViewEventController controller = new ViewEventController(new ViewEventInteractor(presenter, eventDataAccessObject));
        controller.execute(event.getID());
        assertEquals("ID in ViewModel should match that of the retrieved event", event.getID(), viewModel.getState().getId());
    }

    @Test
    public void testViewFail() throws IOException {
        EventFactory factory = new CommonEventFactory();
        eventDataAccessObject = new TestDataAccessObject(factory);
        ViewEventSuccessViewModel viewModel = new ViewEventSuccessViewModel();
        ViewEventPresenter presenter = new ViewEventPresenter(new ViewManagerModel(), viewModel);
        ViewEventController controller = new ViewEventController(new ViewEventInteractor(presenter, eventDataAccessObject));
        controller.execute("-1");
        assertEquals("Nonexistent event was somehow retrieved", "", viewModel.getState().getId());
    }

}
