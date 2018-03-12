package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Question;
import com.japanredsun.Service.Implement.QuestionServiceImp;
import com.japanredsun.Service.QuestionService;
import com.japanredsun.View.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable{
    public TableView<Question> tbQuestion;
    public TableColumn<Question,Long> colId;
    public TableColumn<Question,String> colType;
    public TableColumn<Question,String> colParagraph;
    public TableColumn<Question,Date> colCreatedDate;
    public TableColumn<Question,String> colStatus;
    public Button btnNew;
    public Button btnUpdate;
    public Button btnDelete;

    private QuestionService service = new QuestionServiceImp();

    private static Question selectedQuestion;

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        AdminPageController.selectedQuestion = selectedQuestion;
    }

    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        tbQuestion.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                selectedQuestion = tbQuestion.getSelectionModel().getSelectedItem();
                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
            }
        });
    }

    public void loadData(){
        colId.setCellValueFactory(new PropertyValueFactory<Question, Long>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<Question, String>("type"));
        colParagraph.setCellValueFactory(new PropertyValueFactory<Question, String>("paragraph"));
        colCreatedDate.setCellValueFactory(new PropertyValueFactory<Question, Date>("createdDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Question, String>("status"));
        ObservableList<Question> list = getQuestionList();
        tbQuestion.setItems(list);
    }

    private ObservableList<Question> getQuestionList(){
        ObservableList<Question> list = null;
        try {
            List<Question> questionList = service.getAllQuestions();
            list = FXCollections.observableList(questionList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }

    //btn Update
    public void ShowUpdateBox(ActionEvent event) throws IOException {
        SceneManager sceneManager = new SceneManager();
        sceneManager.openNewWindow(FxmlView.UPDATE,event);
    }
}
