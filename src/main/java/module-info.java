open module com.example.eventlink {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires javax.ws.rs.api;
    requires java.desktop;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


//    opens com.example.eventlink to javafx.fxml;

    exports com.example.eventlink.view;
    exports com.example.eventlink.app;
//    opens com.example.eventlink.view to javafx.fxml;
//    opens com.example.eventlink.app to javafx.fxml;

    exports com.example.eventlink.interface_adapter;
//    opens com.example.eventlink.interface_adapter to javafx.fxml;

    exports com.example.eventlink.interface_adapter.guest_in;
//    opens com.example.eventlink.interface_adapter.guest_in to javafx.fxml;

    exports com.example.eventlink.view.logged_in;
//    opens com.example.eventlink.view.logged_in to javafx.fxml;

    exports com.example.eventlink.view.guest;
//    opens com.example.eventlink.view.guest to javafx.fxml;
    exports com.example.eventlink.app.use_case_factories;
//    opens com.example.eventlink.app.use_case_factories to javafx.fxml;
}