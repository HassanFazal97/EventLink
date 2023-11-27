package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.sound.midi.Soundbank;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.HashMap;

/**
 * Code Framework from Almas Baimagambetov (almaslvl@gmail.com)
 */
public class ViewManager implements PropertyChangeListener {
    private static Scene scene;
    private static HashMap<String, ViewModel> viewModels = new HashMap<String, ViewModel>();
    private static HashMap<String, Controller> controllers = new HashMap<String, Controller>();

    private static HashMap<String, String> viewFiles = new HashMap<String, String>();

    // TODO: Figure out how to implement the ViewManagerModel (CA uses beans for changes, so we need to know if we're
    //  doing the same or different)
    private static ViewManagerModel viewManagerModel;

    public ViewManager(ViewManagerModel viewManagerModel) {
        ViewManager.viewManagerModel = viewManagerModel;
        viewManagerModel.addPropertyChangeListener(this);
    }
    public static void setScene(Scene scene) {ViewManager.scene = scene;}
    public static void addViewModel(String view, ViewModel viewModel){viewModels.put(view, viewModel);}
    public static void addController(String view, Controller controller){controllers.put(view, controller);}
    public static void switchTo(String view) {
        System.out.println("attempting");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ViewManager.class.getResource(view));
            Parent root = fxmlLoader.load();
            scene.setRoot(root);

            ViewController controller = fxmlLoader.getController();
            controller.setViewModel(viewModels.get(view));
            controller.setController(controllers.get(view));
            controller.setViewManagerModel(viewManagerModel);

            System.out.println("success!");
        } catch (IOException ignored) {
            System.out.println("failed");
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String view = (String) evt.getNewValue();
            switchTo(view);
            System.out.println("Changed view to: " + view);
        }
    }
}
