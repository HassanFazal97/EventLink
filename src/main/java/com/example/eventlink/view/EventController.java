package com.example.eventlink.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EventController {
    @FXML
    public Label eventID;

    public EventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }
}
