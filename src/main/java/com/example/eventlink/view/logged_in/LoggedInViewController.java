package com.example.eventlink.view.logged_in;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeText;
    public Label messageLabel;
    @FXML
    private ListView<Event> eventView;
    private ViewManagerModel viewManagerModel;
    private LoggedInViewModel loggedInViewModel;

    public LoggedInViewController() {}

    public void setViewModel(ViewModel loggedInViewModel) {
        this.loggedInViewModel = (LoggedInViewModel) loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);
    }
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    @FXML
    public void initialize() {
        eventView.setCellFactory(param -> new CustomLoggedInEventCell<>());
        System.out.println("Initializing ListView");
    }

    public void createEventButtonClick() {
        System.out.println("Pressed Create Event");
        this.viewManagerModel.setActiveView(CreateEventViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void logOutButtonClick() {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        String welcomeMessage = state.getWELCOME() + state.getName();
        String message = state.getMessage();
        ObservableList<Event> events = FXCollections.observableArrayList(state.getEvents());
        welcomeText.setText(welcomeMessage);
        messageLabel.setText(message);
        eventView.setItems(events);
    }
}
