module com.example.teemaschinefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.teemaschinefx to javafx.fxml;
    exports com.example.teemaschinefx;
}