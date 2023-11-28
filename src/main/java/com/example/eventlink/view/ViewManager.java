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
    private static final HashMap<String, ViewModel> viewModels = new HashMap<String, ViewModel>();
    private static final HashMap<String, Controller> controllers = new HashMap<String, Controller>();
    private static ViewManagerModel viewManagerModel;

    public ViewManager(ViewManagerModel viewManagerModel) {
        ViewManager.viewManagerModel = viewManagerModel;
        viewManagerModel.addPropertyChangeListener(this);
    }

    //Sets the scene where all GUI elements go.
    public static void setScene(Scene scene) {ViewManager.scene = scene;}
    //Injects a viewModel keyed to the name of an associated FXML file.
    public static void addViewModel(String view, ViewModel viewModel){viewModels.put(view, viewModel);}
    //Injects a controller keyed to the name of an associate FXML file.
    public static void addController(String view, Controller controller){controllers.put(view, controller);}

    public static void switchTo(String view) {
        System.out.println("attempting");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ViewManager.class.getResource(view));
            Parent root = fxmlLoader.load();
            scene.setRoot(root);

            //Retrives the viewController for the current view and injects the wanted viewModel + controller.
            ViewController controller = fxmlLoader.getController();
            controller.setViewManagerModel(viewManagerModel);
            controller.setViewModel(viewModels.get(view));
            controller.setController(controllers.get(view));

            System.out.println("success!");
        } catch (IOException ignored) {
            System.out.println("failed");
        }
    }

    public static ViewManagerModel getviewManagerModel() {return viewManagerModel;}

    //This allows ViewManager to be called in order to update.
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String view = (String) evt.getNewValue();
            switchTo(view);
            System.out.println("Changed view to: " + view);
        }
    }
}
