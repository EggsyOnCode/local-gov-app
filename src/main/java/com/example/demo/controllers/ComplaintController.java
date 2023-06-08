package com.example.demo.controllers;


import com.example.demo.models.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.demo.models.Complaint;
import com.example.demo.views.ViewFactory;
import javax.swing.text.View;

public class ComplaintController implements Initializable {

    public Button general;
    public Button cleanliness;
    public Button crime;
    public Button telecom;
    public Button infrastructure;
    public Button health;
    public Button education;
    public Button excise;



    private void toComplaintDesc() throws IOException{

        Model.getInstance().getViewFactory().getComplaintDesc();

    }



    public void initialize(URL url, ResourceBundle resourceBundle) {

        general.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Baldia baldia = new Baldia();
            baldia.setComplainType();
        });

        cleanliness.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Cleanliness cleanliness = new Cleanliness();
            cleanliness.setComplainType();
        });

        crime.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Crime crime = new Crime();
            crime.setComplainType();
        });

        telecom.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Telecom telecom = new Telecom();
            telecom.setComplainType();
        });

        infrastructure.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Infrastructure infrastructure = new Infrastructure();
           infrastructure.setComplainType();
        });

        health.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Health health = new Health();
            health.setComplainType();
        });

        education.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Education education = new Education();
            education.setComplainType();
        });

        excise.setOnAction(ActionEvent -> {
            try {
                toComplaintDesc();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Excise excise = new Excise();
            excise.setComplainType();
        });






    }












}
