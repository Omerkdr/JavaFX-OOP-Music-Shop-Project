module com.example.omerkadir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.omerkadir to javafx.fxml;
    exports com.example.omerkadir;
}