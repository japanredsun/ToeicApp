package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;
import com.japanredsun.View.FxmlView;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable {

    private UserService userService = new UserServiceImp();

    private SceneManager sceneManager = new SceneManager();


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
            try {
                if(userService.authenticate(username,password)){
    //                AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/sample2.fxml"));
    //                rootPane.getChildren().setAll(pane);
                    if(AppConfig.getLoginUser().getRole().equals("ADMIN")){
                        sceneManager.openNewWindowAndHide(FxmlView.ADMIN, event);
                    }else {
                        sceneManager.openNewWindowAndHide(FxmlView.HOME, event);
                    }
                }else {
                    lbError.setText("Sign in error");
                }
            } catch (SQLException e) {
               lbError.setText(e.getMessage());
            } catch (ClassNotFoundException e) {
                lbError.setText(e.getMessage());
            }
        }else {
            lbError.setText("Fill the blank!");
        }



    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
