package com.japanredsun.Config;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneManager {

    private static final Logger LOG = Logger.getLogger(SceneManager.class.getName());

    public void openNewWindowAndHide(String fxmlPath, String title, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(true);
        stage.show();
        LOG.log(Level.INFO,"Switch to " +fxmlPath);
    }

    public void openNewWindow(String fxmlPath, String title, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
        LOG.log(Level.INFO,"Switch to " +fxmlPath);
    }
}
