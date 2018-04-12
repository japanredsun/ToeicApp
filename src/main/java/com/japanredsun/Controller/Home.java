package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Badge;
import com.japanredsun.Model.UserInfo;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;
import com.japanredsun.View.FxmlView;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Home implements Initializable{
    public AnchorPane rootPane;
    public Button btnStart;
    public Label lberror;
    public Text txtid;
    public Text txtrole;
    public ProgressBar pbPoint;
    public Label lbGrade;
    public HBox hbPoints;
    public Label lbPointView;
    public Label lbLevel;

    private UserService service = new UserServiceImp();

    private UserInfo userInfo;

    private Badge myBadge;

    public void initialize(URL location, ResourceBundle resources) {
          txtid.setText(AppConfig.getLoginUser().getUsername());
          txtrole.setText(AppConfig.getLoginUser().getRole());
          hbPoints.setPadding(new Insets(5,5,5,0));
          lbPointView.setPadding(new Insets(0,5,0,0));
          lbLevel.setPadding(new Insets(0,5,0,5));
          loadData();
    }

    private void loadData(){
        try {
            this.userInfo = service.getUserInfo(AppConfig.getLoginUser().getUsername());
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.myBadge = service.evaluate(userInfo.getTotalPoint());
        lbGrade.setText(myBadge.getGrade());
        double value = service.calculatePb(myBadge,userInfo.getTotalPoint());
        pbPoint.setProgress(value);
        lbPointView.setText(userInfo.getTotalPoint().toString());
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
