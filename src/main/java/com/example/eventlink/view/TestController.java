package com.example.eventlink.view;

import javafx.event.ActionEvent;

public class TestController {
    public void Switch(ActionEvent event) {
        ViewManager.switchTo("/com.example.eventlink/login-view.fxml");
        System.out.println("click");
    }
}
