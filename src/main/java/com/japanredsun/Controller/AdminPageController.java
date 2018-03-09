package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable{
    public Label lbUser;

    public void initialize(URL location, ResourceBundle resources) {
        lbUser.setText(AppConfig.getLoginUser().getUsername() + " ADMIN");
    }
}
