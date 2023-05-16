package com.example.demo.views;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private AnchorPane dashboard;

    public ViewFactory(){};
    public AnchorPane getDashboard() {
        if(dashboard==null){
            try{
                dashboard = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return dashboard;
    }

    public void openDashboard(){
        AnchorPane dashboard = getDashboard();
        Scene scene = new Scene(dashboard);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void getLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createStage(loader);
    }

    public void getSignUp() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signup.fxml"));
        createStage(loader);
    }

    public void getRegister() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registerOption.fxml"));
        createStage(loader);
    }

    public void getClient() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client.fxml"));
        createStage(loader);
    }

    public void getPersonalInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/personal.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) throws IOException {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.show();

    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
