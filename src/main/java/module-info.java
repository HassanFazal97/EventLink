module com.example.eventlink {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;
    requires java.desktop;


    opens com.example.eventlink to javafx.fxml;
    exports com.example.eventlink.view;
    opens com.example.eventlink.view to javafx.fxml;
}