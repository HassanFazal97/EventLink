package com.example.eventlink.view.guest;

import com.example.eventlink.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class GuestEventController extends ViewController {
    @FXML
    public Label eventID;
    public Label eventName;
    public Text eventSummary;
    public Label eventStart;
    public Label eventEnd;

    public GuestEventController() {}

    public void setEventID(String id) {
        eventID.setText(id);
    }
}
