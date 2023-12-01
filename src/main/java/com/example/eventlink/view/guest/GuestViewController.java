package com.example.eventlink.view.guest;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GuestViewController extends ViewController implements PropertyChangeListener {
    @FXML
    private ListView<Event> eventView;
    private GuestViewModel guestViewModel;
    private ViewManagerModel viewManagerModel;

    public void setViewModel(ViewModel guestViewModel) {
        this.guestViewModel = (GuestViewModel) guestViewModel;
        this.guestViewModel.addPropertyChangeListener(this);
    }
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    @FXML
    public void initialize() {
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GuestState state = (GuestState) evt.getNewValue();
        ObservableList<Event> events = FXCollections.observableArrayList(state.getEvents());
        eventView.setItems(events);
    }
}
