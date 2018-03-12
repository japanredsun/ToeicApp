package com.japanredsun.Controller;

import com.japanredsun.Model.Answer;
import com.japanredsun.Model.QuestionDetails;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateDetailController implements Initializable{


    public TextField txtQuestion;
    public TextField txtAudio;
    public TextField txtPicture;
    public TextField txtAnswer1;
    public TextField txtAnswer2;
    public TextField txtAnswer3;
    public TextField txtAnswer4;
    public ToggleButton btnTrue1;
    public ToggleButton btnTrue2;
    public ToggleButton btnTrue3;
    public ToggleButton btnTrue4;
    public TextArea txtExplain1;
    public TextArea txtExplain2;
    public TextArea txtExplain3;
    public TextArea txtExplain4;

    private QuestionDetails questionDetails = UpdateBoxController.getSelectedQuestionDetail();




    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    public void loadData(){
        txtQuestion.setText(questionDetails.getQuestion());
        txtAudio.setText(questionDetails.getAudioPath());
        txtPicture.setText(questionDetails.getPicturePath());
        for (Answer answer:questionDetails.getAnswers()){
            
        }
    }
}
