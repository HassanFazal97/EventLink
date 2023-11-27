package com.example.eventlink.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EventViewController {
    @FXML
    private ListView eventView;

    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        eventView.setItems(items);
        eventView.setCellFactory(param -> new CustomEventCell<String>());
        System.out.println("Initializing ListView");
    }

    public EventViewController() {
        System.out.println("EVC initialized");
    }
    public void logInButtonClick(ActionEvent event) {
    }
}
