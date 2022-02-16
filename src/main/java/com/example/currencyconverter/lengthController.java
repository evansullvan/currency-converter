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

public class lengthController implements Initializable {


    @FXML
    private Label welcomeText;

    @FXML
    private TextField lengthIn;

    @FXML
    private TextField lengthOut;

    @FXML
    private ComboBox lengthtypeIn;
    @FXML
    private ComboBox lengthtypeOut;

    @FXML
    private Label info;





    @FXML
    protected void onNumberEntered(){

        double output = 0;
        String lengthtype1 = (String) lengthtypeIn.getValue();
        String lengthtype2 = (String) lengthtypeOut.getValue();



        switch (lengthtype1){
            case "Meter":
                switch (lengthtype2){
                    case "Foot":

                        output = Double.valueOf(lengthIn.getText())*3.281;
                        break;
                    case "Cm":

                        output = Double.valueOf(lengthIn.getText())*100;
                        break;

                    case "Inch":

                        output = Double.valueOf(lengthIn.getText())*39.37;
                        break;

                    case "Meter":

                        output = Double.valueOf(lengthIn.getText())*1;
                        break;
                }
                break;
            case "Foot":
                switch (lengthtype2){
                    case "Meter":

                        output = Double.valueOf(lengthIn.getText())/3.281;
                        break;

                    case "Cm":

                        output = Double.valueOf(lengthIn.getText())*30.48;
                        break;

                    case "Inch":

                        output = Double.valueOf(lengthIn.getText())*12;
                        break;

                    case "Foot":

                        output = Double.valueOf(lengthIn.getText())*1;
                        break;
                }
                break;

            case "Cm":
                switch (lengthtype2){
                    case "Inch":

                        output = Double.valueOf(lengthIn.getText())/2.54;
                        break;

                    case "Meter":

                        output = Double.valueOf(lengthIn.getText())/100;
                        break;

                    case "Foot":

                        output = Double.valueOf(lengthIn.getText())/30.48;


                        break;

                    case "Cm":

                        output = Double.valueOf(lengthIn.getText())*1;


                        break;
                }
                break;
        }
        double output2 =  Math.round(output * 10000.0) / 10000.0;
        info.setText(lengthIn.getText()+" "+lengthtypeIn.getValue()+ " = " +output2+" "+ lengthtypeOut.getValue());



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {




        ObservableList<String> currencytypein = FXCollections.observableArrayList("Foot","Cm","Inch","Meter");

        ObservableList<String> currencytypeout = FXCollections.observableArrayList("Foot","Cm","Inch","Meter");




            lengthtypeIn.setItems(currencytypein);
            lengthtypeOut.setItems(currencytypeout);
            lengthtypeIn.setValue("Meter");
            lengthtypeOut.setValue("Foot");



    }




}
