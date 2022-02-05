module com.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.currencyconverter to javafx.fxml;
exports com.example.currencyconverter;


}