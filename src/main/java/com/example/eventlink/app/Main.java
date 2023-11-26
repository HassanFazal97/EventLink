package com.example.eventlink.app;

import com.example.eventlink.view.ViewManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());

        ViewManager.setScene(scene);
        ViewManager.switchTo("/com.example.eventlink/login-view.fxml");

        stage.setScene(scene);
        stage.show();
    }
}
