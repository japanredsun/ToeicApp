package com.japanredsun.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.japanredsun.Config.SceneManager;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class StartTestPageController implements Initializable {

    public SceneManager scenemanager = new SceneManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void switchlisten(ActionEvent event) throws IOException{
        scenemanager.openNewWindowAndHide(FxmlView.LISTENING_TEST_PAGE, event);
    }
    
    @FXML
    public void switchreading(ActionEvent event) throws IOException{
        scenemanager.openNewWindowAndHide(FxmlView.READING_TEST_PAGE, event);
    }
    
    @FXML
    public void switchhome(ActionEvent event){
        SceneManager scenemanager = new SceneManager();
        try {
            scenemanager.openNewWindowAndHide(FxmlView.HOME, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
}
