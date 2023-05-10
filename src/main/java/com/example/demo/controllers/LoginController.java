package com.example.demo.controllers;

import com.example.demo.models.Model;

import com.example.demo.models.Resident;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public javafx.scene.control.TextField loginId;
    public PasswordField loginpswd;
    public javafx.scene.control.Button btnLogin;
    public javafx.scene.control.Button btnToRegister;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setOnAction(actionEvent -> loginToDashboard());
        btnToRegister.setOnAction(actionEvent -> loginToRegister());

        String id = loginId.getText();
        String pswd = loginpswd.getText();
        Resident res(id, pswd);

    }

    private void loginToDashboard(){
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().openDashboard();

    }

    private void loginToRegister(){
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        try {
            Model.getInstance().getViewFactory().getRegister();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
