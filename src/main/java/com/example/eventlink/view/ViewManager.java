package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Code Framework from Almas Baimagambetov (almaslvl@gmail.com)
 */
public class ViewManager {
    private static Scene scene;

    // TODO: Figure out how to implement the ViewManagerModel (CA uses beans for changes, so we need to know if we're
    //  doing the same or different)
    private ViewManagerModel viewManagerModel;

    public ViewManager(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }
    public static void setScene(Scene scene) {
        ViewManager.scene = scene;
    }

    public static void switchTo(String view) {
        System.out.println("attempting");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ViewManager.class.getResource(view));
            Parent root = fxmlLoader.load();
            scene.setRoot(root);
            System.out.println("success!");
        } catch (IOException ignored) {
            System.out.println("failed");
        }
    }
}
