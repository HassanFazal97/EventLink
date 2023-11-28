package com.example.eventlink.view.logged_in;

import com.example.eventlink.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoggedInEventController extends ViewController {
    @FXML
    public Label eventID;

    public LoggedInEventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }

    public void viewClick(ActionEvent event) {}
}
