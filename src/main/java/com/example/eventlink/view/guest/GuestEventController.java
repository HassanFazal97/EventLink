package com.example.eventlink.view.guest;

import com.example.eventlink.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GuestEventController extends ViewController {
    @FXML
    public Label eventID;

    public GuestEventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }
}
