package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home implements Initializable{
    public AnchorPane rootPane;

    public Label lbUsername;
    
    
    
    public Button btnStart;
    public Button btnManage;
    public Button btnManageUser;
    public Button btnSignout;
    public Label lberror;
    public Text txtid;
    public Text txtpass;
    public Text txtrole;


    public void initialize(URL location, ResourceBundle resources) {
          txtid.setText(AppConfig.getLoginUser().getUsername());
          txtrole.setText(AppConfig.getLoginUser().getRole());
    }
    
    @FXML
    public void switchtest(ActionEvent event) throws IOException{
        SceneManager scenemanager = new SceneManager();
        scenemanager.openNewWindowAndHide(FxmlView.START_TEST_PAGE, event);
        
    }
    
    @FXML
    public void switchadmin(ActionEvent event) throws IOException{
        if (AppConfig.getLoginUser().getRole().equals("ADMIN")){
            SceneManager scenemanager = new SceneManager();
            scenemanager.openNewWindowAndHide(FxmlView.ADMIN, event);
        } else {
            lberror.setText("Access Denied");
        }
    }
    
    @FXML
    public void switchuser(ActionEvent event) throws IOException{
        if (AppConfig.getLoginUser().getRole().equals("ADMIN")){
            SceneManager scenemanager = new SceneManager();
            scenemanager.openNewWindowAndHide(FxmlView.MANAGE_USER_PAGE, event);
        } else {
            lberror.setText("Access Denied");
        }
    }
    
    @FXML
    public void signout(ActionEvent event) throws IOException{
        AppConfig.setLoginUser(null);
        SceneManager scene = new SceneManager();
        scene.openNewWindowAndHide(FxmlView.LOGIN, event);
    }

}
