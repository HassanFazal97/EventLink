package com.example.eventlink.view.guest;

import com.example.eventlink.entity.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomGuestEventCell<T> extends ListCell<T>{
    private AnchorPane root;
    private GuestEventController eventController;

    public CustomGuestEventCell() {
        loadFXML();
    }
    @FXML
    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.eventlink/guest-event.fxml"));
            root = loader.load();
            eventController = loader.getController();
        } catch (IOException e) {
            System.out.println("Event Init failed");
        }
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || !(item instanceof Event)) {
            setGraphic(null);
        } else {
            String name = ((Event) item).getName();
            String id = ((Event) item).getID();
            String summary = ((Event) item).getSummary();
            String start = ((Event) item).getStart();
            String end = ((Event) item).getEnd();
            eventController.setEventName(name);
            eventController.setEventID(id);
            eventController.setEventSummary(summary);
            eventController.setEventStart(start);
            eventController.setEventEnd(end);
            setGraphic(root);
        }
    }
}
