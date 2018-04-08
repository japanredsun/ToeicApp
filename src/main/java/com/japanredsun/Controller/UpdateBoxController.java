package com.japanredsun.Controller;

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Answer;

import com.japanredsun.Model.QuestionDetails;
import com.japanredsun.Model.Status;

import com.japanredsun.View.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UpdateBoxController extends AdminPageController implements Initializable{

    public TextArea txtPara;
    public ComboBox<Status> cbStatus;
    public Button btnUBSave;
    public Button btnUBCLose;
    public AnchorPane paneUpdateBox;
    public TabPane tabPane;
    public Font font = Font.font("System",FontWeight.BOLD,15);
    public Font fontlight = Font.font("System",15);
    public ComboBox<String> cbQuestionType;

    private ObservableList<QuestionDetails> list = getQuestionDetailList();
    private List<TextField> txtTextFieldList = new ArrayList<>();
    private List<TextArea> txtAnswerList = new ArrayList<>();
    private List<ToggleButton> btnTrueList = new ArrayList<>();
    private List<TextArea> txtExplainList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadData();
    }
    private void LoadData(){
        cbQuestionType.setItems(service.getTypes());
        cbQuestionType.getSelectionModel().select(getSelectedQuestion().getType());
        txtPara.setText(getSelectedQuestion().getParagraph());
        cbStatus.setItems(statuses);
        String status = getSelectedQuestion().getStatus();
        if(status.equals("Active")){
            cbStatus.getSelectionModel().select(0);
        }else{
            cbStatus.getSelectionModel().select(1);
        }
        int questionNumber = 1;
        for (QuestionDetails question :
                list) {
            //Tabs
            Tab tab = new Tab("Question "+questionNumber);


            //Tab content: Question + Answers
            BorderPane questionDetailPane = new BorderPane();
            GridPane paneTop = new GridPane();
            Label lbques = new Label("Question:");
            lbques.setFont(font);
            Label lbaudio = new Label("Audio:");
            lbaudio.setFont(font);
            Label lbpic = new Label("Picture");
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
            txtQuestion.setText(question.getQuestion());
            txtQuestion.setId("txtQuestion"+questionNumber);
            txtTextFieldList.add(txtQuestion);
            txtAudio.setText(question.getAudioPath());
            txtAudio.setId("txtAudio"+questionNumber);
            txtTextFieldList.add(txtAudio);
            txtPicture.setText(question.getPicturePath());
            txtPicture.setId("txtPicture"+questionNumber);
            txtTextFieldList.add(txtPicture);
            paneTop.add(txtQuestion,1,0);
            paneTop.add(txtAudio,1,1);
            paneTop.add(txtPicture,1,2);

            paneTop.setHgap(5); paneTop.setVgap(5);
            paneTop.setPadding(new Insets(10));
            questionDetailPane.setTop(paneTop);

            //Answer
            List<Answer> answerList = question.getAnswers();
            GridPane paneMid = new GridPane();
            Label lbid = new Label("ID");
            lbid.setFont(fontlight);
            Label lbanswer = new Label("Answer:");
            lbanswer.setFont(fontlight);
            Label lbaccu = new Label("Accuracy");
            lbaccu.setFont(fontlight);
            Label lbexplain = new Label("Explain:");
            lbexplain.setFont(fontlight);
            paneMid.setAlignment(Pos.CENTER);
            paneMid.add(lbid,0,0);
            paneMid.add(lbanswer,1,0);
            paneMid.add(lbaccu,2,0);
            paneMid.add(lbexplain,3,0);

            ToggleGroup toggleGroup = new ToggleGroup();

            int i = 1;
            for (Answer answer :
                    answerList) {
                paneMid.add(new Label("Answer " + answer.getId()),0,i);

                TextArea txtAnswer = new TextArea();
                txtAnswer.setText(answer.getAnswer());
                txtAnswer.setId(String.format("txtAnswer_%d_%d",questionNumber,i));
                txtAnswerList.add(txtAnswer);
                paneMid.add(txtAnswer,1,i);

                ToggleButton btnTrue = new ToggleButton();
                toggleGroup.getToggles().add(btnTrue);
                btnTrue.setText("True");
                btnTrue.setId(String.format("btnTrue_%d_%d",questionNumber,i));
                if(answer.isRightAnswer())
                    btnTrue.setSelected(true);
                btnTrueList.add(btnTrue);
                paneMid.add(btnTrue,2,i);

                TextArea txtExplain = new TextArea();
                txtExplain.setText(answer.getExplain());
                txtExplain.setId(String.format("txtExplain_%d_%d",questionNumber,i));
                txtExplainList.add(txtExplain);
                paneMid.add(txtExplain,3,i);
                i++;
                paneMid.setVgap(5);paneMid.setHgap(5);
                paneMid.setPadding(new Insets(5));
            }
            questionDetailPane.setCenter(paneMid);

            tab.setContent(questionDetailPane);
            tabPane.getTabs().add(tab);
            questionNumber ++;
        }
    }

    private ObservableList<QuestionDetails> getQuestionDetailList(){
        return FXCollections.observableList(getSelectedQuestion().getQuestions());
    }

    public void saveQuestion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to save this question?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            saveQuestion();
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

    private void saveQuestion(){
        int questionNumber = 1;
        List<QuestionDetails> newQuestionDetailList = new ArrayList<>();
        for (QuestionDetails question :
                list) {
            for (TextField txt :
                    txtTextFieldList) {
                if(txt.getId().equals("txtQuestion"+questionNumber)){
                    question.setQuestion(txt.getText());
                } if(txt.getId().equals("txtAudio"+questionNumber)){
                    question.setAudioPath(txt.getText());
                }else if(txt.getId().equals("txtPicture"+questionNumber)){
                    question.setPicturePath(txt.getText());
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

            question.setAnswers(newAnswerList);
            newQuestionDetailList.add(question);

            questionNumber++;
        }

        getSelectedQuestion().setType(cbQuestionType.getSelectionModel().getSelectedItem());
        getSelectedQuestion().setParagraph(txtPara.getText());
        getSelectedQuestion().setStatus(String.valueOf(cbStatus.getSelectionModel().getSelectedItem().getCode()));
        getSelectedQuestion().setQuestions(newQuestionDetailList);
        service.saveQuestion(getSelectedQuestion());
        getSelectedQuestion().setStatus(cbStatus.getSelectionModel().getSelectedItem().toString());
    }

    public void closeUpdateBox(ActionEvent event) {
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
