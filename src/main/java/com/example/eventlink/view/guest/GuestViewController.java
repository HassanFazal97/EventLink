package com.example.eventlink.view.guest;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class GuestViewController extends ViewController {
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
        eventView.setCellFactory(param -> new CustomGuestEventCell<>());
        System.out.println("Initializing ListView");
    }

    public GuestViewController() {
        System.out.println("GVC initialized");
    }

    public void logInButtonClick() {
        System.out.println("Pressed Login");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
