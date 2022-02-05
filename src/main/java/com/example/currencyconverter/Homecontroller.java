package com.example.currencyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Homecontroller {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField currencyIn;

    @FXML
    private TextField currencyOut;

    @FXML
    private ComboBox currencytypeIn;
    @FXML
    private ComboBox currencytypeOut;




    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onNumberEntered(){

    currencyOut.setText(String.valueOf(Integer.parseInt(currencyIn.getText())*2));




    }

    public boolean isValidnumber(String number) {

        String ePattern = "^[0-9999999999999999999999999999999999999999999999999]";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(number);
        return m.matches();


    }


}
