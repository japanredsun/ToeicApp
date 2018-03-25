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

public class UpdateUserController extends AdminPageController implements Initializable {
    
    public Button btnUpdate;
    public Button btnCancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
