package com.example.demo.controllers;

import com.example.demo.models.Model;

import com.example.demo.models.Resident;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Notifications;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public javafx.scene.control.TextField loginId;
    public PasswordField loginpswd;
    private String temp_id;
    private String temp_pswd;
    public javafx.scene.control.Button btnLogin;
    public javafx.scene.control.Button btnToRegister;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setOnAction(actionEvent -> loginToDashboard());
        btnToRegister.setOnAction(actionEvent -> loginToRegister());



    }

    private void loginToDashboard(){
        boolean result;
        temp_pswd = loginpswd.getText();
        System.out.println(temp_pswd);
        temp_id = loginId.getText();
        System.out.println(temp_id);
        result = Model.getInstance().authenticate(temp_id,temp_pswd);
//        try{
//
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        if(result==true){
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().openDashboard();
        }
        else{
            Notifications.create()
                    .title("Title")
                    .text("Incorrect Credentials Entered! Try Again!")
                    .darkStyle()
                    .showInformation();
        }


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
