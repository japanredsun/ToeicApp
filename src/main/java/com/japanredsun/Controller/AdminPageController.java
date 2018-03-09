package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Model.Question;
import com.japanredsun.Service.Implement.QuestionServiceImp;
import com.japanredsun.Service.QuestionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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


    private QuestionService service = new QuestionServiceImp();

    public void initialize(URL location, ResourceBundle resources) {
        loadData();
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
}
