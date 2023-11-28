package com.example.eventlink.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//This class only exists to debug UI issues, namely to figure out if the UI itself is buggy or another class is.
public class UILauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.eventlink/guest-view.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 320, 240);
        primaryStage.setTitle("EventLink");

        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

