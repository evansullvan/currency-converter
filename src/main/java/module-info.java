module com.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.currencyconverter to javafx.fxml;
    exports com.example.currencyconverter;
    exports com.example.currencyconverter.controller;
    opens com.example.currencyconverter.controller to javafx.fxml;
    exports com.example.currencyconverter.model;
    opens com.example.currencyconverter.model to javafx.fxml;
}