package com.example.eventlink.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class CustomEventCell<T> extends ListCell<T> {
    private AnchorPane root;
    private EventController eventController;
    public CustomEventCell() {
        loadFXML();
        System.out.println("attempting CustomEventCell load");
    }

    @FXML
    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.eventlink/event.fxml"));
            root = loader.load();
            eventController = loader.getController();
            System.out.println(Optional.ofNullable(loader.getController()));
            System.out.println("FXML LOADED");
        } catch (IOException e) {
            System.out.println("Event Init failed");
        }
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            eventController.setEventID((String) item);
            setGraphic(root);
        }
    }
}
