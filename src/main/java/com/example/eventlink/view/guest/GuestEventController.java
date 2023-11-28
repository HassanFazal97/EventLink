package com.example.eventlink.view.guest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GuestEventController {
    @FXML
    public Label eventID;

    public GuestEventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }
}
