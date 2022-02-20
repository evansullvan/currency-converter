package com.example.currencyconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class menuController {

    @FXML
    private Label feedback;


    @FXML
    void onlengthclicked(ActionEvent event) {
        try {
            /*we can reuse this code in many projects, it changes scenes*/ Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("length.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);

            stage.setTitle("length");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            feedback.setText("Unable to load length screen");
        }
    }

    @FXML
    void oncurrencyclicked(ActionEvent event) {
        try {
            /*we can reuse this code in many projects, it changes scenes*/ Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("currency.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);

            stage.setTitle("currency converter");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            feedback.setText("Unable to load currency screen");
        }
    }
}
