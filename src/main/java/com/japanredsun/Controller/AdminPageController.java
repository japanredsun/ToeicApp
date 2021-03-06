package com.japanredsun.Controller;

import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.Status;
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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

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

    protected QuestionService service = new QuestionServiceImp();

    protected ObservableList<Status> statuses = service.getStatuses();

    private ObservableList<Question> list = getQuestionList();

    private static Question selectedQuestion;

    public Question getSelectedQuestion() {
        return selectedQuestion;
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
        tbQuestion.setItems(list);
    }

    private ObservableList<Question> getQuestionList(){
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
        sceneManager.openNewWindowAndHide(FxmlView.UPDATE,event);
    }

    public void addNewQuestion(ActionEvent event) throws IOException {
        SceneManager sceneManager = new SceneManager();
        sceneManager.openNewWindowAndHide(FxmlView.INSERT_PAGE,event);
    }

    public void deleteQuestion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to delete this question?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            try {
                service.deleteQuestion(selectedQuestion.getId());
            } catch (SQLException e) {
                Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Warning");
                // Header Text: null
                alert2.setHeaderText(null);
                alert2.setContentText(e.getMessage());
                alert2.showAndWait();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // update list
            list = getQuestionList();
            tbQuestion.setItems(list);
        }
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
