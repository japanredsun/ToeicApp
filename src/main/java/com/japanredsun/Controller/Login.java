package com.japanredsun.Controller;

import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    private UserService userService = new UserServiceImp();

    public Label lbError;
    public Button btnSwitch;
    public AnchorPane rootPane;
    public TextField txtUserName;
    public PasswordField txtPassword;

    @FXML
    public void switchScene(ActionEvent event) throws IOException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        if(!username.equals("") || !password.equals("")){
            if(userService.authenticate(username,password)){
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/sample2.fxml"));
//                rootPane.getChildren().setAll(pane);
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample2.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.setTitle("Toeic Application");
                stage.show();
            }else {
                lbError.setText("Sign in error");
            }
        }else {
            lbError.setText("Fill the blank!");
        }



    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
