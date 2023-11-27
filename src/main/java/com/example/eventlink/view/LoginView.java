package com.example.eventlink.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.eventlink/event.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 320, 240);
        primaryStage.setTitle("EventLink");

        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

