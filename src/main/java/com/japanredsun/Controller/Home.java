package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable{
    public AnchorPane rootPane;

    public Label lbUsername;


    public void initialize(URL location, ResourceBundle resources) {
//        lbUsername.setText(AppConfig.getLoginUser().getUsername() + " USER");
//        System.out.println(AppConfig.getLoginUser().toString());
    }

}
