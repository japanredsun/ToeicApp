/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.User;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class InsertUserController extends ManageUserPageController implements Initializable {
    
    public Button btnCancel;
    public Button btnAdd;
    public ComboBox<String> cbRole;
    public TextField txtUsername;
    public TextField txtPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbRole.setItems(roleList);
    }   
    
    @FXML
    public void switchmanageuser(ActionEvent event){
        try {
            SceneManager scenemanager = new SceneManager();
            scenemanager.openNewWindowAndHide(FxmlView.MANAGE_USER_PAGE, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void addUser(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to add this user?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            addingUser();
            Stage stage = (Stage) btnAdd.getScene().getWindow();
            stage.close();
            SceneManager sceneManager = new SceneManager();
            try {
                sceneManager.openNewWindowAndHide(FxmlView.MANAGE_USER_PAGE,event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addingUser(){
        String username = txtUsername.getText();
        String password =txtPassword.getText();
        String role = cbRole.getSelectionModel().getSelectedItem();
        User user = new User(username,password,role);
        user.setId(0);
        user.setIsActive("1");
        try {
            service.save(user);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
