package com.japanredsun.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.japanredsun.AppConfig;
import com.japanredsun.Config.SceneManager;
import com.japanredsun.Model.Answer;
import com.japanredsun.Model.Question;
import com.japanredsun.Model.QuestionDetails;
import com.japanredsun.Model.UserInfo;
import com.japanredsun.Service.Implement.QuestionServiceImp;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.QuestionService;
import com.japanredsun.Service.UserService;
import com.japanredsun.View.FxmlView;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Danh
 */
public class ListeningTestPageController implements Initializable {


    public VBox vbQuestionArea;
    public Text lbQuestion;
    public ToggleGroup answer;
    public RadioButton cb1;
    public RadioButton cb2;
    public RadioButton cb3;
    public RadioButton cb4;
    public Text txtAnswer1;
    public Text txtAnswer2;
    public Text txtAnswer3;
    public Text txtAnswer4;
    public Text lbQuestionNum;
    public Label lbPoint;
    public Text lbParagraph;


    private QuestionService service = new QuestionServiceImp();

    private UserService userService = new UserServiceImp();

    private List<Question> questions = new ArrayList<>();

    private int questionNumber = 1;

    private int questionDetailNumberIndex = 0;

    private int countQuestionDetails = 1;

    private UserInfo userInfo;

    private Integer totalPoint = 0;

    private Answer selectedAnswer;

    private List<QuestionDetails> questionDetailsList;

    private Question currentQuestion;

    private RadioButton selectedRadio;

    private ImageView imageView = new ImageView();

    private String audioURL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            questions = service.getQuestionsByTest("Listening");
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            userInfo = userService.getUserInfo(AppConfig.getLoginUser().getUsername());
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        answer.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (answer.getSelectedToggle() != null) {
                    selectedAnswer = (Answer) answer.getSelectedToggle().getUserData();
                    selectedRadio = (RadioButton) answer.getSelectedToggle().getToggleGroup().getSelectedToggle();
                }
            }
        });
        vbQuestionArea.getChildren().add(imageView);
        totalPoint = userInfo.getTotalPoint();
        lbQuestionNum.setText("Question " + questionNumber);
        loadData();
    }

    private void loadData(){
        if(questions.size() > 0){
            currentQuestion = questions.get(new Random().nextInt(questions.size()));
            lbPoint.setText(String.valueOf(totalPoint));
            lbParagraph.setText(currentQuestion.getParagraph());
            questionDetailsList = currentQuestion.getQuestions();
            countQuestionDetails = questionDetailsList.size();
            loadQuestionDetail();

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"No questions in database or no more question to do",new ButtonType("OK"));
            alert.showAndWait();
        }
    }

    private void loadQuestionDetail(){
        QuestionDetails questionDetail = questionDetailsList.get(questionDetailNumberIndex);
        lbQuestion.setText(questionDetail.getQuestion());
        // if exist audio or picture
        // LOAD audio Picture HERE
        String url = this.getClass().getResource(questionDetail.getPicturePath()).toString();
        if(!url.isEmpty()){
            Image image = new Image(url);
            imageView.setImage(image);
            imageView.setFitHeight(300);
            imageView.setFitWidth(400);
        }

        audioURL = questionDetail.getAudioPath();
        playAudio(audioURL);

        //load answer
        List<Answer> answerList = questionDetail.getAnswers();
        Answer answer1 = answerList.get(0);
        txtAnswer1.setText(answer1.getAnswer());
        cb1.setUserData(answer1);

        Answer answer2 = answerList.get(1);
        txtAnswer2.setText(answer2.getAnswer());
        cb2.setUserData(answer2);

        Answer answer3 = answerList.get(2);
        txtAnswer3.setText(answer3.getAnswer());
        cb3.setUserData(answer3);

        Answer answer4 = answerList.get(3);
        txtAnswer4.setText(answer4.getAnswer());
        cb4.setUserData(answer4);
    }

    private void loadQuestionNumber(){
        lbQuestionNum.setText("Question " + questionNumber);
    }

    private void playAudio(String url){
        if(!url.equals("")){
            AudioClip note = new AudioClip(this.getClass().getResource(url).toString());
            note.play();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"No audio path found!",new ButtonType("OK"));
            alert.showAndWait();
            System.out.println("No audio found!");
        }
    }
    
    @FXML
    public void closeTestPage(ActionEvent event){
        SceneManager scenemanager = new SceneManager();
        try {
            scenemanager.openNewWindowAndHide(FxmlView.START_TEST_PAGE, event);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void guide(ActionEvent event) {
        String type = currentQuestion.getType();
        if(type.equals(service.getTypes().get(0))){
            playAudio("");
        }else if (type.equals(service.getTypes().get(1))){
            playAudio("");
        }else if(type.equals(service.getTypes().get(2))){
            playAudio("");
        }else if(type.equals(service.getTypes().get(3))){
            playAudio("");
        }
    }


    public void listenAgain(ActionEvent event) {
        playAudio(audioURL);
    }

    public void submitAnswer(ActionEvent event) {
        if(selectedAnswer.isRightAnswer()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Correct Answer \n" + selectedAnswer.getExplain(),new ButtonType("OK"));
            alert.showAndWait();
            totalPoint++;
            lbPoint.setText(String.valueOf(totalPoint));
            if(questionDetailNumberIndex + 1 == countQuestionDetails){
                questionDetailNumberIndex = 0;
                countQuestionDetails = 1;
                questionDetailsList.clear();
                questions.remove(currentQuestion);
                questionNumber++;
                if(questions.isEmpty()){
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION,"Out of question",new ButtonType("OK"));
                    alert2.showAndWait();
                }else{
                    selectedRadio.setSelected(false);
                    loadQuestionNumber();
                    loadData();
                }
            }else {
                questionDetailNumberIndex++;
                questionNumber++;
                selectedRadio.setSelected(false);
                loadQuestionNumber();
                loadQuestionDetail();

            }
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Wrong Answer \n"+ selectedAnswer.getExplain(),new ButtonType("OK"));
            alert.showAndWait();
            if(totalPoint > 0){
                totalPoint = totalPoint - 1;
                lbPoint.setText(String.valueOf(totalPoint));
            }
        }

        //Update total Point
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(AppConfig.getLoginUser().getUsername());
        userInfo.setTotalPoint(totalPoint);
        try {
            userService.updateUserInfo(userInfo);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
