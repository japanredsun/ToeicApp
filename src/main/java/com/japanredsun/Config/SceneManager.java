package com.japanredsun.Config;

import com.japanredsun.View.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneManager {

    private static final Logger LOG = Logger.getLogger(SceneManager.class.getName());

    public void openNewWindowAndHide(FxmlView fxmlView, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlView.getFxmlFile()));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle(fxmlView.getTitle());
        stage.setResizable(false);
        stage.show();
        LOG.log(Level.INFO,"Switch to " + fxmlView.getFxmlFile());
    }

    public void openNewWindow(FxmlView fxmlView, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlView.getFxmlFile()));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle(fxmlView.getTitle());
        stage.show();
        LOG.log(Level.INFO,"Switch to " +fxmlView.getFxmlFile());
    }
}
