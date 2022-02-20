package com.example.currencyconverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Currencycontroller implements Initializable {
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
    private Label feedback;

    double output = 0;

    String exchangerate1 = (String) currencytypeIn.getValue();
    String exchangerate2 = (String) currencytypeOut.getValue();





    @FXML
    void onbackclicked(ActionEvent event) {
        try {
            /*we can reuse this code in many projects, it changes scenes*/ Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);

            stage.setTitle("length");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
feedback.setText("Unable to return home");
        }
    }




    @FXML
    protected void onNumberEntered(){

//currency in is in euro



        switch (exchangerate1){
            case "USD":
                switch (exchangerate2){
                    case "EURO":

                         output = Double.valueOf(currencyIn.getText())*0.8735;
                        break;
                    case "POUND-STERLING":

                        output = Double.valueOf(currencyIn.getText())*0.75;
                        break;

                    case "USD":

                        output = Double.valueOf(currencyIn.getText())*1;
                        break;
                }
                break;
            case "EURO":
                switch (exchangerate2){
                    case "USD":

                        output = Double.valueOf(currencyIn.getText())*1.14;
                        break;

                    case "POUND-STERLING":

                        output = Double.valueOf(currencyIn.getText())*0.85;
                        break;

                    case "EURO":

                        output = Double.valueOf(currencyIn.getText())*1;
                        break;
                }
                break;

            case "POUND-STERLING":
                switch (exchangerate2){
                    case "USD":

                        output = Double.valueOf(currencyIn.getText())*1.35;
                        break;

                    case "POUND-STERLING":

                        output = Double.valueOf(currencyIn.getText())*1;
                        break;

                    case "EURO":

                            output = Double.valueOf(currencyIn.getText())*1.18;


                        break;
                }
                break;
        }
       double output2 =  Math.round(output * 10000.0) / 10000.0;
        info.setText(currencyIn.getText()+" "+currencytypeIn.getValue()+ " = " +output2+" "+ currencytypeOut.getValue());



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
        currencytypeIn.setValue("USD");
        currencytypeOut.setValue("POUND-STERLING");
    }
}
