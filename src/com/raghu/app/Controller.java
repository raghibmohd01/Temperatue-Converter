package com.raghu.app;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button convertButton;
    @FXML
    public TextField textField;
    @FXML
    public Label   welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;

    private static final  String c_To_F="Celcius to Fahrenheit";
    private boolean is_C_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        choiceBox.getItems().add(c_To_F);
        choiceBox.setValue(c_To_F);
        choiceBox.getItems().add("Fahrenheit to Celcius");

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if(newValue.equals(c_To_F)) {
                    is_C_F=true;
                } else
                    is_C_F=false;
            }
        });


        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button clicked");

              convert();
            }
        });
    }

    private void convert() {
        float newTemp=0.0f;
        float temp=0.0f;
        String unit=null;
          String inputTemp=textField.getText();
         try {
             temp =Float.parseFloat(inputTemp);
             System.out.println(temp);
         }
         catch (Exception ex) {
             Alert errorAlert=new Alert(Alert.AlertType.ERROR);
             errorAlert.setTitle("Error Occured");
             errorAlert.setHeaderText("Invalid input!");
             errorAlert.setContentText("Plaese enter temperature in valid format.");
             errorAlert.show();
             return;
         }

          if(is_C_F) {
              newTemp= (float) ((temp * 9.0 / 5.0) + 32.0);
              System.out.println(newTemp);
             unit=" F";
          }
          else {
              newTemp= (float) ((temp-32 )*5.0/9.0);
              System.out.println(newTemp);
              unit=" C";
          }

        Alert result=new Alert(Alert.AlertType.INFORMATION);
          result.setTitle("Result");

          result.setContentText("New temperature: "+newTemp+unit);
          result.show();


    }
}
