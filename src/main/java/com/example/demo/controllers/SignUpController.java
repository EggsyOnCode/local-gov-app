package com.example.demo.controllers;

import com.example.demo.models.Model;
import com.example.demo.models.Resident;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public TextField signName;
    public TextField signUC;
    public TextField signPeriod;
    public TextField signFam;
    public TextField signCNIC;
    public TextField signID;
    public PasswordField signPswd;
    public Button btnSign;

    private Resident res;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSign.setOnAction(actionEvent -> tologin());

    }
    //to ensure if all textfields are not empty
    private boolean isValid(){
        if(signCNIC.getText().isEmpty()==false && signUC.getText().isEmpty()==false && signName.getText().isEmpty()==false &&
                signID.getText().isEmpty()==false && signPswd.getText().isEmpty()==false && signPeriod.getText().isEmpty()==false &&
                 signFam.getText().isEmpty()==false)
        {
//            System.out.println("all is good");
            return true;
        }
        else{
            return false;
        }
    }
    private void tologin(){
        String id = signID.getText();
        String name = signName.getText();
        String cnic = signCNIC.getText();
        String pswd = signPswd.getText();
        String uc = signUC.getText();
        String fam = signFam.getText();
        String period =signPeriod.getText();
        if(isValid()==true){
            Model.getInstance().addToDB(id, pswd, name, cnic, uc, fam , period);

            Stage stage = (Stage) btnSign.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            try {
                Model.getInstance().getViewFactory().getLoginPage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            res = new Resident(name,cnic,uc,period,fam,id,pswd);
        }
        else{
            Notifications.create()
                    .title("Error Msg")
                    .text("One of the Fields is empty; plz populate all the fields!")
                    .darkStyle()
                    .showInformation();
        }

    }

}
