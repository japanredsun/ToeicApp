package com.japanredsun.Controller;

import com.japanredsun.Model.Answer;
import com.japanredsun.Model.QuestionDetails;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UpdateDetailController implements Initializable{


    public TextField txtQuestion;
    public TextField txtAudio;
    public TextField txtPicture;
    public GridPane gdAnswer;
    public Button btnSave;
    public Button btnClose;

    private QuestionDetails questionDetails = UpdateBoxController.getSelectedQuestionDetail();

    List<TextArea> txtAnswerList = new ArrayList<>();
    List<ToggleButton> btnTrueList = new ArrayList<>();
    List<TextArea> txtExplainList = new ArrayList<>();


    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    public void loadData(){
        txtQuestion.setText(questionDetails.getQuestion());
        txtAudio.setText(questionDetails.getAudioPath());
        txtPicture.setText(questionDetails.getPicturePath());
        List<Answer> answerList = questionDetails.getAnswers();

        ToggleGroup toggleGroup = new ToggleGroup();



        int i = 1;
        for (Answer answer :
                answerList) {
            gdAnswer.add(new Label("Answer " + answer.getId()),0,i);

            TextArea txtAnswer = new TextArea();
            txtAnswer.setText(answer.getAnswer());
            txtAnswer.setId("txtAnswer"+i);
            txtAnswerList.add(txtAnswer);
            gdAnswer.add(txtAnswer,1,i);

            ToggleButton btnTrue = new ToggleButton();
            toggleGroup.getToggles().add(btnTrue);
            btnTrue.setText("True");
            btnTrue.setId("btnTrue"+i);
            if(answer.isRightAnswer())
                btnTrue.setSelected(true);
            btnTrueList.add(btnTrue);
            gdAnswer.add(btnTrue,2,i);

            TextArea txtExplain = new TextArea();
            txtExplain.setText(answer.getExplain());
            txtExplain.setId("txtExplain"+i);
            txtExplainList.add(txtExplain);
            gdAnswer.add(txtExplain,3,i);
            i++;
        }
    }

    public void closeWindows() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void openDialog(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notice");
        alert.setContentText("Do you want to save this question?");

        Optional<ButtonType> result = alert.showAndWait();

        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            saveQuestionDetail();
            closeWindows();
        }

    }

    public void saveQuestionDetail(){
        System.out.println("SAVE");
        QuestionDetails newQuestionDetail = new QuestionDetails();
        newQuestionDetail.setQuestion(txtQuestion.getText());
        newQuestionDetail.setAudioPath(txtAudio.getText());
        newQuestionDetail.setPicturePath(txtPicture.getText());
        List<Answer> newAnswerList = new ArrayList<>();
        for (int i = 0; i<4;i++){
           TextArea txtAnswer = txtAnswerList.get(i);
           ToggleButton btnTrue = btnTrueList.get(i);
           TextArea txtExplain = txtExplainList.get(i);

           String answer = txtAnswer.getText();
           boolean accurary = false;
           if(btnTrue.isSelected())
               accurary = true;
           String explain = txtExplain.getText();

           Answer newAnswer = new Answer(i + 1,answer,accurary,explain);
           newAnswerList.add(newAnswer);
        }

        newQuestionDetail.setAnswers(newAnswerList);
        questionDetails = newQuestionDetail;
    }
}
