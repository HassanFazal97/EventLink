package com.example.eventlink;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void loginButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

