package com.example.eventlink.view.logged_in;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.view.ViewController;
import com.example.eventlink.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class LoggedInEventController extends ViewController {
    @FXML
    public Label eventID;
    public Label eventName;
    public Text eventSummary;
    public Label eventStart;
    public Label eventEnd;

    private ViewManagerModel viewManagerModel;

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    public LoggedInEventController() {
        setViewManagerModel(ViewManager.getviewManagerModel());
    }

    public void setEventID(String id) {
        eventID.setText(id);
    }

    public void viewClick() {
        System.out.println("Pressed View Event");
        this.viewManagerModel.setActiveView(ViewEventViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
