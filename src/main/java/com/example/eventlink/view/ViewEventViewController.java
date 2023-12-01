package com.example.eventlink.view;


import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventState;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.text.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewEventViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeMessage;
    public TextField existingEventName;
    public TextField existingStartDay;
    public TextField existingStartTime;
    public TextField existingEndDay;
    public TextField existingEndTime;
    public TextField existingSummary;

    private ViewManagerModel viewManagerModel;
    private ViewEventViewModel viewEventViewModel;

    public void setViewModel(ViewModel viewEventViewModel) {
        this.viewEventViewModel = (ViewEventViewModel) viewEventViewModel;
        this.viewEventViewModel.addPropertyChangeListener(this);
    }
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

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

    public void goBackButtonClick(ActionEvent event) {
        System.out.println("Pressed Go Back");
        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void modifyButtonClick(ActionEvent event) {
        System.out.println("Pressed Modify Event");
        this.viewManagerModel.setActiveView(ModifyViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void registerButtonClick(ActionEvent event) {
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewEventState state = (ViewEventState) evt.getNewValue();
        String welcomeMessage = "Welcome " + state.getUserName();
        this.welcomeMessage.setText(welcomeMessage);
        System.out.println("Label Updated");
    }
}
