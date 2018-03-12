package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.Main;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;
import com.japanredsun.View.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateBoxController extends AdminPageController implements Initializable{

    public TextField txtType;
    public TextArea txtPara;
    public ComboBox cbStatus;
    public Button btnUBSave;
    public Button btnUBCLose;
    public TableView<QuestionDetails> tbQuestionDetail;
    public TableColumn<QuestionDetails,String> colQdQuestion;
    public TableColumn<QuestionDetails,String> colAudio;
    public TableColumn<QuestionDetails,String> colPicture;
    public Button btnEdit;
    public Button btnReview;

    private static QuestionDetails selectedQuestionDetail;

    public static QuestionDetails getSelectedQuestionDetail() {
        return selectedQuestionDetail;
    }

    public static void setSelectedQuestionDetail(QuestionDetails selectedQuestionDetail) {
        UpdateBoxController.selectedQuestionDetail = selectedQuestionDetail;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadData();
        tbQuestionDetail.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                selectedQuestionDetail = tbQuestionDetail.getSelectionModel().getSelectedItem();
                btnEdit.setDisable(false);
            }
        });
    }

    public void LoadData(){
        txtType.setText(getSelectedQuestion().getType());
        txtPara.setText(getSelectedQuestion().getParagraph());
        colQdQuestion.setCellValueFactory(new PropertyValueFactory<QuestionDetails, String>("question"));
        colAudio.setCellValueFactory(new PropertyValueFactory<QuestionDetails, String>("audio"));
        colPicture.setCellValueFactory(new PropertyValueFactory<QuestionDetails, String>("picture"));
        tbQuestionDetail.setItems(getQuestionDetailList());

    }

    private ObservableList<QuestionDetails> getQuestionDetailList(){
        return FXCollections.observableList(getSelectedQuestion().getQuestions());
    }

    public void editQuestionDetail(ActionEvent event) throws IOException {
        SceneManager sceneManager = new SceneManager();
        sceneManager.openNewWindow(FxmlView.UPDATE_DETAIL,event);
    }
}
