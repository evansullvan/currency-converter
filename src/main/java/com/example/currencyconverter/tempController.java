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

public class tempController implements Initializable {
    @FXML
    private TextField tempIn;

    @FXML
    private TextField tempOut;

    @FXML
    private ComboBox temptypeIn;
    @FXML
    private ComboBox temptypeOut;

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
        String temptype1 = (String) temptypeIn.getValue();
        String temptype2 = (String) temptypeOut.getValue();



        switch (temptype1) {
            case "Fahrenheit":
                switch (temptype2) {
                    case "Celsius":

                        output = ((Double.valueOf(tempIn.getText())-32)*5)/9;
                        break;

                    case "Fahrenheit":

                        output = Double.valueOf(tempIn.getText()) * 1;
                        break;

                }
                break;
            case "Celsius":
                switch (temptype2) {
                    case "Fahrenheit":

                        output = ((Double.valueOf(tempIn.getText())*9)/5)+32;
                        break;

                    case "Celsius":

                        output = Double.valueOf(tempIn.getText()) *1;
                        break;
                }
                break;



        }
        double output2 =  Math.round(output * 10000.0) / 10000.0;
        info.setText(tempIn.getText()+" "+temptypeIn.getValue()+ " = " +output2+" "+ temptypeOut.getValue());



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ObservableList<String> currencytypein = FXCollections.observableArrayList("Celsius","Fahrenheit");

        ObservableList<String> currencytypeout = FXCollections.observableArrayList("Celsius","Fahrenheit");




        temptypeIn.setItems(currencytypein);
        temptypeOut.setItems(currencytypeout);
        temptypeIn.setValue("Celsius");
        temptypeOut.setValue("Fahrenheit");


    }
}
