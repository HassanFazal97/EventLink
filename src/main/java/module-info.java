module com.example.eventlink {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;


    opens com.example.eventlink to javafx.fxml;
    exports com.example.eventlink;
}