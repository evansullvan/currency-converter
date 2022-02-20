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
    private Label feedback;

@FXML
    void onbackclicked(ActionEvent event) {
        try {
            /*we can reuse this code in many projects, it changes scenes*/ Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);

            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
feedback.setText("unable to return home");
        }
    }




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

            case "Inch":
                switch (lengthtype2){
                    case "Inch":

                        output = Double.valueOf(lengthIn.getText())*1;
                        break;

                    case "Meter":

                        output = Double.valueOf(lengthIn.getText())/39.37;
                        break;

                    case "Foot":

                        output = Double.valueOf(lengthIn.getText())/12;


                        break;

                    case "Cm":

                        output = Double.valueOf(lengthIn.getText())*2.54;


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
