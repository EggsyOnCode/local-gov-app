package com.example.demo.controllers;

import com.example.demo.models.Model;
import com.example.demo.models.Resident;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.controlsfx.control.Notifications;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    public Button btnPersonalAdd;
    public ImageView imgDP;
    public Text txtName;
    public Text txtProfession;
    public Text txtAddress;
    public Text txtPhone;
    public Text txtGender;
    public Text UCname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            btnPersonalAdd.setOnAction(actionEvent -> {
                try {
                    toPersonalInfo();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


                txtName.setText(Resident.getInstance().getfName());
                txtAddress.setText(Resident.getInstance().getAddress());
                txtGender.setText(Resident.getInstance().getGender());
                txtPhone.setText(Resident.getInstance().getPhone());
                txtProfession.setText(Resident.getInstance().getProfession());
                UCname.setText(Resident.getInstance().getUc());
//                try {
//                    imgDP.setImage(convertByteArrayToImage(Resident.getInstance().getProfilePic()));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }



    }

    private void toPersonalInfo() throws IOException {
        Model.getInstance().getViewFactory().getPersonalInfo();
    }

    //method to check if a property has already been set; if yes binding it to the text views; otherwise proompting the user to set it
    private boolean checkViews(){
        if(Resident.getInstance().getProfession()==null || Resident.getInstance().getAddress()==null ||
                Resident.getInstance().getPhone()==null || Resident.getInstance().getGender()==null
        || Resident.getInstance().getProfilePic()==null){
//            Notifications.create()
//                    .title("Error Msg")
//                    .text("Your Profile is not completely setup; click the Add Profile Info button!")
//                    .darkStyle()
//                    .showInformation();
            return false;
        }
        else{
            return true;
        }
    }

    private Image convertByteArrayToImage(byte[] imageData) throws IOException {
        // Convert byte array to Image
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        BufferedImage bufferedImage = ImageIO.read(bais);

        // Create a WritableImage and copy the pixel data
        WritableImage writableImage = new WritableImage(bufferedImage.getWidth(), bufferedImage.getHeight());
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        int[] pixels = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        pixelWriter.setPixels(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(),
                PixelFormat.getIntArgbInstance(), pixels, 0, bufferedImage.getWidth());

        return writableImage;
    }
}
