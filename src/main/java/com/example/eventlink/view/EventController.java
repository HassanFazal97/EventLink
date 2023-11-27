package com.example.eventlink.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EventController {
    @FXML
    public Label eventID;

    public EventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }

    public void registerClick(ActionEvent event) {
        System.out.println(eventID.getText());
        System.out.println("registered");
    }

    public void modifyEventClick(ActionEvent event) {
        System.out.println("no");
    }
}
