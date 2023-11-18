module com.example.eventlink {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eventlink to javafx.fxml;
    exports com.example.eventlink;
}