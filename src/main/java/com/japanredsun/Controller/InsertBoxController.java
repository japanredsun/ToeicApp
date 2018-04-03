package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Answer;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;
import com.japanredsun.Model.Status;
import com.japanredsun.Service.Implement.QuestionServiceImp;
import com.japanredsun.Service.QuestionService;
import com.japanredsun.View.FxmlView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InsertBoxController extends AdminPageController implements Initializable {
    public TextArea txtPara;
    public ComboBox<Status> cbStatus;
    public Button btnUBSave;
    public Button btnUBCLose;
    public TabPane tabPane;
    public Button btnAddTab;
    public Button btnRemoveTab;
    public Font font = Font.font("System",FontWeight.BOLD,15);
    public Font fontlight = Font.font("System",15);
    public ComboBox<String> cbQuestionType;

    private int questionNumber = 1;

    private List<TextField> txtTextFieldList = new ArrayList<>();
    private List<TextArea> txtAnswerList = new ArrayList<>();
    private List<ToggleButton> btnTrueList = new ArrayList<>();
    private List<TextArea> txtExplainList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadInsertBox();
    }

    public void loadInsertBox(){
        cbQuestionType.setPromptText("Choose question type");
        cbQuestionType.setItems(service.getTypes());
        txtPara.setPromptText("Paragraph for reading type");
        cbStatus.setItems(statuses);
        cbStatus.getSelectionModel().select(0);


        Tab tab = new Tab("Question " +questionNumber);
        createTabContent(tab);
        tabPane.getTabs().add(tab);

    }

    public void createTabContent(Tab tab){
        //Tab content: Question + Answers
        BorderPane questionDetailPane = new BorderPane();
        GridPane paneTop = new GridPane();
        Label lbques = new Label("Question:");
        lbques.setFont(font);
        Label lbaudio = new Label("Audio:");
        lbaudio.setFont(font);
        Label lbpic = new Label("Picture:");
        lbpic.setFont(font);
        paneTop.setAlignment(Pos.CENTER);
        paneTop.add(lbques,0,0);
        paneTop.add(lbaudio,0,1);
        paneTop.add(lbpic,0,2);

        //Question
        TextField txtQuestion = new TextField();
        txtQuestion.setPrefWidth(1024);
        TextField txtAudio = new TextField();
        TextField txtPicture = new TextField();
        txtQuestion.setPromptText("Enter question " +questionNumber);
        txtQuestion.setId("txtQuestion"+questionNumber);
        txtTextFieldList.add(txtQuestion);
        txtAudio.setPromptText("Audio path");
        txtAudio.setId("txtAudio"+questionNumber);
        txtTextFieldList.add(txtAudio);
        txtPicture.setPromptText("Picture path");
        txtPicture.setId("txtPicture"+questionNumber);
        txtTextFieldList.add(txtPicture);
        paneTop.add(txtQuestion,1,0);
        paneTop.add(txtAudio,1,1);
        paneTop.add(txtPicture,1,2);

        paneTop.setHgap(5); paneTop.setVgap(5);
        paneTop.setPadding(new Insets(10));
        questionDetailPane.setTop(paneTop);

        GridPane paneMid = new GridPane();
        paneMid.setAlignment(Pos.CENTER);
        Label lbid = new Label("ID");
        lbid.setFont(fontlight);
        Label lbanswer = new Label("Answer:");
        lbanswer.setFont(fontlight);
        Label lbaccu = new Label("Accuracy");
        lbaccu.setFont(fontlight);
        Label lbexplain = new Label("Explain:");
        lbexplain.setFont(fontlight);
        paneMid.add(lbid,0,0);
        paneMid.add(lbanswer,1,0);
        paneMid.add(lbaccu,2,0);
        paneMid.add(lbexplain,3,0);

        ToggleGroup toggleGroup = new ToggleGroup();

        for (int i = 1; i <= 4;i++){
            paneMid.add(new Label("Answer " + i),0,i);

            TextArea txtAnswer = new TextArea();
            txtAnswer.setPromptText("Answer "+i);
            txtAnswer.setId(String.format("txtAnswer_%d_%d",questionNumber,i));
            txtAnswerList.add(txtAnswer);
            paneMid.add(txtAnswer,1,i);

            ToggleButton btnTrue = new ToggleButton();
            toggleGroup.getToggles().add(btnTrue);
            btnTrue.setText("True");
            btnTrue.setId(String.format("btnTrue_%d_%d",questionNumber,i));
//            if(answer.isRightAnswer())
//                btnTrue.setSelected(true);
            btnTrueList.add(btnTrue);
            paneMid.add(btnTrue,2,i);

            TextArea txtExplain = new TextArea();
            txtExplain.setPromptText("Explain for this answer");
            txtExplain.setId(String.format("txtExplain_%d_%d",questionNumber,i));
            txtExplainList.add(txtExplain);
            paneMid.add(txtExplain,3,i);
            paneMid.setVgap(5);paneMid.setHgap(5);
            paneMid.setPadding(new Insets(5));
        }
        questionDetailPane.setCenter(paneMid);

        tab.setContent(questionDetailPane);
    }

    public void saveQuestion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to save this question?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            saveQuestionDetails();
            Stage stage = (Stage) btnUBSave.getScene().getWindow();
            stage.close();
            SceneManager sceneManager = new SceneManager();
            try {
                sceneManager.openNewWindowAndHide(FxmlView.ADMIN,event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveQuestionDetails(){
        int questionListSize = tabPane.getTabs().size();
        List<QuestionDetails> questionDetailsList = new ArrayList<>();
        for (int questionNumber = 1; questionNumber <= questionListSize; questionNumber++){
            QuestionDetails questionDetails = new QuestionDetails();
            for (TextField txt :
                    txtTextFieldList) {
                if(txt.getId().equals("txtQuestion"+questionNumber)){
                    questionDetails.setQuestion(txt.getText());
                } if(txt.getId().equals("txtAudio"+questionNumber)){
                    questionDetails.setAudioPath(AppConfig.AUDIO_PATH + txt.getText());
                }else if(txt.getId().equals("txtPicture"+questionNumber)){
                    questionDetails.setPicturePath(AppConfig.PICTURE_PATH + txt.getText());
                }
            }
            List<Answer> newAnswerList = new ArrayList<>();
            String answer = null;
            boolean accuracy = false;
            String explain = null;
            for (int j = 1; j <= 4;j++){
                for (TextArea txtAnswer :
                        txtAnswerList) {
                    if (txtAnswer.getId().equals(String.format("txtAnswer_%d_%d", questionNumber, j))) {
                        answer = txtAnswer.getText();
                    }
                }
                for (ToggleButton btnTrue :
                        btnTrueList) {
                    if (btnTrue.getId().equals(String.format("btnTrue_%d_%d", questionNumber, j))){
                        accuracy = btnTrue.isSelected();
                    }
                }
                for (TextArea txtExplain :
                        txtExplainList) {
                    if(txtExplain.getId().equals(String.format("txtExplain_%d_%d",questionNumber,j))){
                        explain = txtExplain.getText();
                    }
                }
                Answer newAnswer = new Answer(j,answer,accuracy,explain);
                newAnswerList.add(newAnswer);
            }
            questionDetails.setAnswers(newAnswerList);
            questionDetailsList.add(questionDetails);
        }
        Question question = new Question();
        question.setId(0);
        question.setType(cbQuestionType.getSelectionModel().getSelectedItem());
        question.setParagraph(txtPara.getText());
        question.setStatus(String.valueOf(cbStatus.getSelectionModel().getSelectedItem().getCode()));
        question.setQuestions(questionDetailsList);
        service.saveQuestion(question);

    }

    public void closeInsertBox(ActionEvent event) {
        Stage stage = (Stage) btnUBSave.getScene().getWindow();
        stage.close();
        SceneManager sceneManager = new SceneManager();
        try {
            sceneManager.openNewWindowAndHide(FxmlView.ADMIN,event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewTab(ActionEvent event) {
        questionNumber++;
        Tab tab = new Tab("Question " +questionNumber);
        createTabContent(tab);
        tabPane.getTabs().add(tab);
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(questionNumber - 1);
    }

    public void removeTab(ActionEvent event) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        tabPane.getTabs().remove(selectionModel.getSelectedIndex());
        int question = 1;
        for (Tab tab :
                tabPane.getTabs()) {
            tab.setText("Question "+ question);
            question++;
        }
        questionNumber = question - 1;
    }
}
