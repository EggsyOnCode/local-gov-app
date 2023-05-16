package com.example.demo.controllers;

import com.example.demo.models.Model;
import com.example.demo.models.Resident;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonalinfoController implements Initializable {
    public TextField txtGender;
    public TextField txtProfession;
    public TextField txtPhoneNumber;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtOrg;
    public TextField txtIsMarried;
    public TextField txtSocial;
    public TextField txtFamily;
    public Button btnSubmit;
    public Button btnImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            btnSubmit.setOnAction(actionEvent -> updateDB());
            btnImage.setOnAction(actionEvent -> {
                try {
                    handleOpenPictures();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    private void updateDB(){
        Model.getInstance().updateDB(Resident.getInstance().getUsername(),
                txtGender.getText(),txtProfession.getText(), txtPhoneNumber.getText(),
                txtEmail.getText(),txtOrg.getText(),txtIsMarried.getText(),
                txtFamily.getText(),txtSocial.getText(),txtAddress.getText());
    }

    private void handleOpenPictures() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");

        File initialDirectory = new File("C:\\Users\\farza\\OneDrive\\Pictures");
        fileChooser.setInitialDirectory(initialDirectory);

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png")
        );

        Stage stage = (Stage) btnImage.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {

            BufferedImage bufferimg = ImageIO.read(selectedFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferimg, "jpg", baos);
            byte[] imageData = baos.toByteArray();
            Resident.getInstance().setProfilePic(imageData);
        }else{
            System.out.println("img not selected");
        }
    }
}
