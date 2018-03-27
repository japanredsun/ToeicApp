/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Status;
import com.japanredsun.Model.User;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateUserController extends ManageUserPageController implements Initializable {
    
    public Button btnUpdate;
    public Button btnCancel;
    public TextField txtID;
    public TextField txtUsername;
    public TextField txtPassword;
    public ComboBox<Status> cbStatus;
    public ComboBox<String> cbRole;

    private User selectedUser = getSelectedUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    private void loadData(){
        txtID.setText(String.valueOf(selectedUser.getId()));
        txtUsername.setText(selectedUser.getUsername());
        txtPassword.setText(selectedUser.getPassword());
        cbStatus.setItems(getStatuses());
        String status = selectedUser.getIsActive();
        if(status.equals("Active")){
            cbStatus.getSelectionModel().select(0);
        }else {
            cbStatus.getSelectionModel().select(1);
        }
        cbRole.setItems(roleList);
        String role = selectedUser.getRole();
        if(role.equals("ADMIN")){
            cbRole.getSelectionModel().select("ADMIN");
        }else {
            cbRole.getSelectionModel().select("USER");
        }
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

    public void updateUser(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to update this user?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            saveUser();
            Stage stage = (Stage) btnUpdate.getScene().getWindow();
            stage.close();
            SceneManager sceneManager = new SceneManager();
            try {
                sceneManager.openNewWindowAndHide(FxmlView.MANAGE_USER_PAGE,event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveUser(){
        getSelectedUser().setUsername(txtUsername.getText());
        getSelectedUser().setPassword(txtPassword.getText());
        getSelectedUser().setRole(cbRole.getSelectionModel().getSelectedItem());
        getSelectedUser().setIsActive(String.valueOf(cbStatus.getSelectionModel().getSelectedItem().getCode()));
        try {
            service.save(getSelectedUser());
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        }
        getSelectedUser().setIsActive(cbStatus.getSelectionModel().getSelectedItem().toString());
    }
}
