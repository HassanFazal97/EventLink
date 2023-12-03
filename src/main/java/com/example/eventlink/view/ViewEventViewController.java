package com.example.eventlink.view;


import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventState;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessState;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    public TextArea existingSummary;

    private ViewManagerModel viewManagerModel;
    private ViewEventSuccessViewModel viewEventSuccessViewModel;

    public void setViewModel(ViewModel viewEventViewModel) {
        this.viewEventSuccessViewModel = (ViewEventSuccessViewModel) viewEventViewModel;
        this.viewEventSuccessViewModel.addPropertyChangeListener(this);
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
        ViewEventSuccessState state = (ViewEventSuccessState) evt.getNewValue();
        String welcomeMessage = "Welcome " + state.getUserName();
        this.welcomeMessage.setText(welcomeMessage);
        this.existingEventName.setText(state.getEventName());
        this.existingStartDay.setText(state.getEventStartDate());
        this.existingStartTime.setText(state.getEventStartTime());
        this.existingEndDay.setText(state.getEventEndDate());
        this.existingEndTime.setText(state.getEventEndTime());
        this.existingSummary.setText(state.getSummary());
        System.out.println("Label Updated");
    }
}
