package com.example.eventlink.app;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.view.ViewManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

//This class only exists to debug UI issues, namely to figure out if the UI itself is buggy or another class is.
public class UILauncher extends Application {
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(viewManagerModel);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewManager.setScene(scene);

        //Set First View
        viewManagerModel.setActiveView(LoginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //Limits our Window to 1280x720
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


}

