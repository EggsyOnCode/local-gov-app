package com.example.demo;

import com.example.demo.forum.ClientController;
import com.example.demo.forum.MainClient;
import com.example.demo.forum.MainServer;
import com.example.demo.models.Model;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        ClientController clientUI = new ClientController(stage);
        Model.getInstance().getViewFactory().getLoginPage();
//        Model.getInstance().getDataofId("faizi", "Organization");
//        Model.getInstance().authenticate("faizi","123");

//        MainServer server = new MainServer();
//        server.start(stage);
//        MainClient client = new MainClient();
//        client.start(stage);

    }


}