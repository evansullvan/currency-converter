package com.example.currencyconverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Homecontroller implements Initializable {
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
    private Label info;




    @FXML
    protected void onNumberEntered(){

//currency in is in euro

        double output = 0;
        String exchangerate1 = (String) currencytypeIn.getValue();
        String exchangerate2 = (String) currencytypeOut.getValue();

        switch (exchangerate1){
            case "USD":
                switch (exchangerate2){
                    case "EURO":
                        info.setText("1 United States Dollar equals 0.87 Euro");
                         output = Double.valueOf(currencyIn.getText())*0.8735;
                        break;
                    case "POUND-STERLING":
                        info.setText("1 United States Dollar equals 0.75 Pounds");
                        output = Double.valueOf(currencyIn.getText())*0.75;
                        break;

                    case "USD":
                        info.setText("1 United States Dollar equals 1 United States Dollar");
                        output = Double.valueOf(currencyIn.getText())*1;
                        break;
                }
                break;
            case "EURO":
                switch (exchangerate2){
                    case "USD":
                        info.setText("1 Euro equals 1.14 United States Dollars");
                        output = Double.valueOf(currencyIn.getText())*1.14;
                        break;

                    case "POUND-STERLING":
                        info.setText("1 Euro equals 0.85 Pounds");
                        output = Double.valueOf(currencyIn.getText())*0.85;
                        break;

                    case "EURO":
                        info.setText("1 Euro equals 1 Euro");
                        output = Double.valueOf(currencyIn.getText())*1;
                        break;
                }
                break;

            case "POUND-STERLING":
                switch (exchangerate2){
                    case "USD":
                        info.setText("1 Pound equals 1.35 United States Dollars");
                        output = Double.valueOf(currencyIn.getText())*1.35;
                        break;

                    case "POUND-STERLING":
                        info.setText("1 Pound equals 1 Pound");
                        output = Double.valueOf(currencyIn.getText())*1;
                        break;

                    case "EURO":
                        info.setText("1 Pound equals 1.18 Euro");
                            output = Double.valueOf(currencyIn.getText())*1.18;


                        break;
                }
                break;
        }

    currencyOut.setText(String.valueOf(output));

    }

    public boolean isValidnumber(String number) {

        String ePattern = "[1-9][0-9]*";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(number);
        return m.matches();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        ObservableList<String> currencytypein = FXCollections.observableArrayList("EURO","USD","POUND-STERLING");

        ObservableList<String> currencytypeout = FXCollections.observableArrayList("EURO","USD","POUND-STERLING");

        currencytypeIn.setItems(currencytypein);
        currencytypeOut.setItems(currencytypeout);
        currencytypeIn.setValue("All");
        currencytypeOut.setValue("All");
    }
}
