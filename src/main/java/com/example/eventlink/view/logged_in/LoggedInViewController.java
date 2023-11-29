package com.example.eventlink.view.logged_in;

import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class LoggedInViewController extends ViewController {
    public Label welcomeText;
    @FXML
    private ListView<String> eventView;
    private ViewManagerModel viewManagerModel;

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "00010002", "010234853", "1203895908");
        eventView.setItems(items);
        eventView.setCellFactory(param -> new CustomLoggedInEventCell<>());
        welcomeText.setText("test");
        System.out.println("Initializing ListView");
    }

    public LoggedInViewController() {
        System.out.println("EVC initialized");
    }

    public void createEventButtonClick(ActionEvent event) {
        System.out.println("Pressed Create Event");
        this.viewManagerModel.setActiveView(CreateEventViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void logOutButtonClick(ActionEvent event) {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
