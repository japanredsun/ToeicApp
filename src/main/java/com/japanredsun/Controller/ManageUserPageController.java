/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ManageUserPageController extends AdminPageController implements Initializable {
    
    public Button btnadd;
    public Button btnupdate;
    public Button btndelete;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    
    
}
