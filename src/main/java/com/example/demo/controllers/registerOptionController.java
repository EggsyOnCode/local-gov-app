package com.example.demo.controllers;

import com.example.demo.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class registerOptionController implements Initializable {
    public Button toSignUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toSignUp.setOnAction(actionEvent -> registerToSignup());
    }

    private void registerToSignup(){
        Stage stage = (Stage) toSignUp.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        try {
            Model.getInstance().getViewFactory().getSignUp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
