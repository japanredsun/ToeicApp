/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Status;
import com.japanredsun.Model.User;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageUserPageController implements Initializable {
    
    public Button btnadd;
    public Button btnupdate;
    public Button btndelete;
    public TableView<User> tbUsers;
    public TableColumn<User,Long> colId;
    public TableColumn<User,String> colUsername;
    public TableColumn<User,String> colPassword;
    public TableColumn<User,String> colRole;
    public TableColumn<User,String> colStatus;
    public TableColumn<User,Date> colCreatedDate;

    protected UserService service = new UserServiceImp();

    private ObservableList<User> list = getUsers();

    private static User selectedUser;

    public static User getSelectedUser() {
        return selectedUser;
    }

    private ObservableList<Status> statuses = service.getStatuses();

    public ObservableList<Status> getStatuses() {
        return statuses;
    }

    public ObservableList<String> roleList = getRoles();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        tbUsers.setOnMousePressed(event -> {
            selectedUser = tbUsers.getSelectionModel().getSelectedItem();
            btnupdate.setDisable(false);
            btndelete.setDisable(false);
        });
    }

    private ObservableList<String> getRoles(){
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("USER");
        return FXCollections.observableArrayList(roles);
    }

    private void loadData(){
        colId.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colCreatedDate.setCellValueFactory(new PropertyValueFactory<User, Date>("createdDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<User, String>("isActive"));
        colRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        tbUsers.setItems(list);
    }

    private ObservableList<User> getUsers(){
        try {
            List<User> users = service.getAllUsers();
            list = FXCollections.observableArrayList(users);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }

    public void switchhome(ActionEvent event){
        SceneManager scenemanager = new SceneManager();
        try {
            scenemanager.openNewWindowAndHide(FxmlView.HOME, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    @FXML
    public void switchadd(ActionEvent event){
        try {
            SceneManager scenemanager = new SceneManager();
            scenemanager.openNewWindowAndHide(FxmlView.INSERT_USER, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    @FXML
    public void switchupdate(ActionEvent event){
        try {
            SceneManager scenemanager = new SceneManager();
            scenemanager.openNewWindowAndHide(FxmlView.UPDATE_USER, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public void deleteUser(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to delete this user?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            try {
                service.detele(selectedUser.getId());
            } catch (SQLException e) {
                Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Warning");
                // Header Text: null
                alert2.setHeaderText(null);
                alert2.setContentText(e.getMessage());
                alert2.showAndWait();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //update list
            list = getUsers();
            tbUsers.setItems(list);
        }
    }
}
