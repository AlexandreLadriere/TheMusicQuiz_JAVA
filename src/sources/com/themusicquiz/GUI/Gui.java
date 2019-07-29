/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:52:11 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-29 11:40:43
 */
package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.lang.System;
import javafx.scene.Node;
import java.util.ArrayList;

import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;
import com.themusicquiz.composants.Quiz;

public class Gui extends Application {

    private Stage window;
    private WelcomeScene welcomeScene;
    private HomeScene homeScene;
    private ModeSelectionScene modeSelectionScene;
    private GenreSelectionScene genreSelectionScene;
    private HiphopLanguageScene hiphopLanguageScene;
    private QuestionScene questionScene;
    private ResultsScene resultsScene;
    private Quiz quiz;

    private long startTime = 0L;
    private long stopTime = 0L;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        quiz = new Quiz();

        try {
            welcomeScene = new WelcomeScene();
            homeScene = new HomeScene();
            addButtonsToController(homeScene);
            modeSelectionScene = new ModeSelectionScene();
            addButtonsToController(modeSelectionScene);
            genreSelectionScene = new GenreSelectionScene();
            addButtonsToController(genreSelectionScene);
            hiphopLanguageScene = new HiphopLanguageScene();
            addButtonsToController(hiphopLanguageScene);
            questionScene = new QuestionScene();
            addButtonsToController(questionScene);
            resultsScene = new ResultsScene();
            addButtonsToController(resultsScene);
            
            window.setScene(welcomeScene);
            window.setTitle("The Music Quiz");
            //pause between welcom scene and homeScene
            PauseTransition delay = new PauseTransition(new Duration((double) 2000));
            delay.setOnFinished( event -> window.setScene(homeScene) );

            delay.play();
            window.show();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addButtonsToController(HomeScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(ModeSelectionScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(GenreSelectionScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(HiphopLanguageScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(QuestionScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(ResultsScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void updateQuestionScene() throws FileNotFoundException {
        if(quiz.getQuestionCpt()<Constantes.NUMBER_OF_QUESTIONS.getValue()) {
            questionScene.colorPropositions();
            startTime = System.currentTimeMillis();
            this.quiz.setCurrentQuestion(quiz.getQuestionSerie().getQuestionSerieQuestionList().get(quiz.getQuestionCpt()));
            this.questionScene.getQuestionLabel().setText(quiz.getCurrentQuestion().askQuestion());
            Image currentCover = new Image(new FileInputStream(quiz.getCurrentQuestion().getQuestionItem().getItemCoverPath()));
            this.questionScene.getCoverLabel().setGraphic(new ImageView(currentCover));
            this.questionScene.getProposition1().setText(quiz.getCurrentQuestion().getProposition(quiz.getCurrentQuestion().getQuestionOptions()[0]));
            this.questionScene.getProposition2().setText(quiz.getCurrentQuestion().getProposition(quiz.getCurrentQuestion().getQuestionOptions()[1]));
            this.questionScene.getProposition3().setText(quiz.getCurrentQuestion().getProposition(quiz.getCurrentQuestion().getQuestionOptions()[2]));
            this.questionScene.getProposition4().setText(quiz.getCurrentQuestion().getProposition(quiz.getCurrentQuestion().getQuestionOptions()[3]));
            this.questionScene.getScoreLabel().setText("Score: "+quiz.getQuestionSerie().getQuestionSerieTotalScore());
            this.quiz.setQuestionCpt(quiz.getQuestionCpt()+1);
        }
        else {
            this.quiz.setQuestionCpt(0);
            this.updateResultsScene();
        }
    }

    public void updateResultsScene() {
        int totalScore = this.quiz.getQuestionSerie().getQuestionSerieTotalScore();
        int totalQuestionAnswered = this.quiz.getQuestionSerie().getQuestionSerieCorrectAnswerNumber();
        float averageTime = this.quiz.getQuestionSerie().getQuestionSerieAverageTime()/1000F;
    
        this.resultsScene.getScoreLabel().setText(String.valueOf(totalScore));
        this.resultsScene.getNumberQuestionLabel().setText(totalQuestionAnswered+"/"+Constantes.NUMBER_OF_QUESTIONS.getValue());
        this.resultsScene.getTimeLabel().setText(averageTime+" sec");
        //totalScore
        if(totalScore<(Constantes.NUMBER_OF_QUESTIONS.getValue()/4)*30) {
            this.getResultsScene().getScoreLabel().setId("score_4");
            this.getResultsScene().getGenreLabel().setText("You suck !");
        }
        else if(totalScore<(Constantes.NUMBER_OF_QUESTIONS.getValue()/2)*30 && totalScore>=(Constantes.NUMBER_OF_QUESTIONS.getValue()/4)*30) {
            this.getResultsScene().getScoreLabel().setId("score_3");
            this.getResultsScene().getGenreLabel().setText("You suck, but it could be worse...");
        }
        else if(totalScore<((Constantes.NUMBER_OF_QUESTIONS.getValue()/2)+(Constantes.NUMBER_OF_QUESTIONS.getValue()/4))*30 && totalScore>=(Constantes.NUMBER_OF_QUESTIONS.getValue()/2)*30) {
            this.getResultsScene().getScoreLabel().setId("score_2");
            this.getResultsScene().getGenreLabel().setText("Not bad, but not good enough...");
        }
        else {
            this.getResultsScene().getScoreLabel().setId("score_1");
            this.getResultsScene().getGenreLabel().setText("I am almost impressed !");
        }
        //totalQuestionAnswered
        if(totalQuestionAnswered<(Constantes.NUMBER_OF_QUESTIONS.getValue()/4)) {
            this.getResultsScene().getNumberQuestionLabel().setId("score_4");
        }
        else if(totalQuestionAnswered<(Constantes.NUMBER_OF_QUESTIONS.getValue()/2) && totalQuestionAnswered>=(Constantes.NUMBER_OF_QUESTIONS.getValue()/4)) {
            this.getResultsScene().getNumberQuestionLabel().setId("score_3");
        }
        else if(totalQuestionAnswered<((Constantes.NUMBER_OF_QUESTIONS.getValue()/2)+(Constantes.NUMBER_OF_QUESTIONS.getValue()/4)) && totalQuestionAnswered>=(Constantes.NUMBER_OF_QUESTIONS.getValue()/2)) {
            this.getResultsScene().getNumberQuestionLabel().setId("score_2");
        }
        else {
            this.getResultsScene().getNumberQuestionLabel().setId("score_1");
        }
        //averageTime
        if(averageTime>6F) {
            this.getResultsScene().getTimeLabel().setId("score_4");
        }
        else if(averageTime<=6F && averageTime>4F) {
            this.getResultsScene().getTimeLabel().setId("score_3");
        }
        else if(averageTime<=4F && averageTime>2F) {
            this.getResultsScene().getTimeLabel().setId("score_2");
        }
        else {
            this.getResultsScene().getTimeLabel().setId("score_1");
        }

        this.window.setScene(resultsScene);
    }

    public void checkAnswerGUI(String answer) {
        stopTime = System.currentTimeMillis();
        quiz.getCurrentQuestion().setQuestionTime(stopTime-startTime);
        this.quiz.getCurrentQuestion().checkAnswer(answer);
        if(quiz.getCurrentQuestion().getQuestionIsCorrect()) {
            questionScene.colorCorrectAnswer(answer);
        }
        else {
            questionScene.colorWrongAnswer(answer);
            questionScene.colorCorrectAnswer(quiz.getCurrentQuestion().getQuestionCorrectAnswer());
        }
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public WelcomeScene getWelcomeScene() {
        return welcomeScene;
    }

    public void setWelcomeScene(WelcomeScene welcomeScene) {
        this.welcomeScene = welcomeScene;
    }

    public HomeScene getHomeScene() {
        return homeScene;
    }

    public void setHomeScene(HomeScene homeScene) {
        this.homeScene = homeScene;
    }

    public ModeSelectionScene getModeSelectionScene() {
        return modeSelectionScene;
    }

    public void setModeSelectionScene(ModeSelectionScene modeSelectionScene) {
        this.modeSelectionScene = modeSelectionScene;
    }

    public GenreSelectionScene getGenreSelectionScene() {
        return genreSelectionScene;
    }

    public void setGenreSelectionScene(GenreSelectionScene genreSelectionScene) {
        this.genreSelectionScene = genreSelectionScene;
    }

    public HiphopLanguageScene getHiphopLanguageScene() {
        return hiphopLanguageScene;
    }

    public void setHiphopLanguageScene(HiphopLanguageScene hiphopLanguageScene) {
        this.hiphopLanguageScene = hiphopLanguageScene;
    }

    public QuestionScene getQuestionScene() {
        return questionScene;
    }

    public void setQuestionScene(QuestionScene questionScene) {
        this.questionScene = questionScene;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public ResultsScene getResultsScene() {
        return resultsScene;
    }

    public void setResultsScene(ResultsScene resultsScene) {
        this.resultsScene = resultsScene;
    }
}