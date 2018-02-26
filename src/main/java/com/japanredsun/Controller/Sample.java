package com.japanredsun.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sample implements Initializable {


    public Button btnSwitch;
    public AnchorPane rootPane;

    @FXML
    public void switchScene(ActionEvent event) throws IOException {
//       Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample2.fxml"));
//       Scene scene = new Scene(root);
//       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//       stage.hide();
//       stage.setScene(scene);
//       stage.show();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/sample2.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
