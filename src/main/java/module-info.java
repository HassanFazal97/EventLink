module com.example.eventlink {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;
    requires java.desktop;


    opens com.example.eventlink to javafx.fxml;
    exports com.example.eventlink.view;
    exports com.example.eventlink.app;
    opens com.example.eventlink.view to javafx.fxml;
    opens com.example.eventlink.app to javafx.fxml;
    exports com.example.eventlink.interface_adapter;
    opens com.example.eventlink.interface_adapter to javafx.fxml;
}