module com.example.yeatdle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.yeatdle to javafx.fxml;
    exports com.example.yeatdle;
}