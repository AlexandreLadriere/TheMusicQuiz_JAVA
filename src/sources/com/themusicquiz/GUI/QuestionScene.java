/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 17:10:24 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-28 17:18:50
 */

package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class QuestionScene extends SceneApp {

    private GridPane grid;
    private Image appLogo;
    private Label appLogoLabel;
    private Label scoreLabel;
    private Label questionLabel;
    private Image coverImage;
    private Label coverLabel;
    private Button proposition1;
    private Button proposition2;
    private Button proposition3;
    private Button proposition4;
    private Button openInBrowserButton;
    private Image openInBrowserLogo;
    private Button infoButton;
    private Image addLogo;
    private Button nextQuestionButton;
    private Image skipNextLogo;

    private Label authorLabel;

    public QuestionScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(3, 10);
        //this.grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.scoreLabel = new Label("Score: 0");
        this.scoreLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.scoreLabel.setAlignment(Pos.CENTER);
        this.scoreLabel.setTextAlignment(TextAlignment.CENTER);
        this.scoreLabel.setId("score_label");
        this.grid.add(scoreLabel, 0, 0, 1, 1);
        this.grid.setMargin(scoreLabel, new Insets(10, 10, 50, 10));

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 18, 18, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 1, 0, 1, 1);
        this.grid.setMargin(appLogoLabel, new Insets(10, 10, 50, 10));

        this.questionLabel = new Label("Question");
        this.questionLabel.setWrapText(true);
        this.questionLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.questionLabel.setAlignment(Pos.CENTER);
        this.questionLabel.setTextAlignment(TextAlignment.CENTER);
        this.questionLabel.setId("question_label");
        this.grid.add(questionLabel, 0, 0, 3, 2);
        this.grid.setMargin(questionLabel, new Insets(20, 10, 0, 10));

        this.coverImage = new Image(new FileInputStream("/home/alexandre/Desktop/code_perso/[JAVA] The Music Quiz/DB/hiphop/FR_hiphop/covers/SCH - A7.jpeg"), 150, 150, true, true);
        this.coverLabel = new Label();
        this.coverLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.coverLabel.setGraphic(new ImageView(coverImage));
        this.coverLabel.setAlignment(Pos.CENTER);
        this.grid.add(coverLabel, 0, 3, 3, 1);
        this.grid.setMargin(coverLabel, new Insets(10, 0, 45, 0));

        this.proposition1 = new Button("Proposition 1");
        this.proposition1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.proposition1.setAlignment(Pos.CENTER);
        this.proposition1.setId("proposition_button");
        this.grid.add(proposition1, 0, 4, 3, 2);
        this.grid.setMargin(proposition1, new Insets(35, 38, 45, 38));

        this.proposition2 = new Button("Proposition 2");
        this.proposition2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.proposition2.setAlignment(Pos.CENTER);
        this.proposition2.setId("proposition_button");
        this.grid.add(proposition2, 0, 5, 3, 2);
        this.grid.setMargin(proposition2, new Insets(35, 38, 45, 38));

        this.proposition3 = new Button("Proposition 3");
        this.proposition3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.proposition3.setAlignment(Pos.CENTER);
        this.proposition3.setId("proposition_button");
        this.grid.add(proposition3, 0, 6, 3, 2);
        this.grid.setMargin(proposition3, new Insets(35, 38, 45, 38));

        this.proposition4 = new Button("Proposition 4");
        this.proposition4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.proposition4.setAlignment(Pos.CENTER);
        this.proposition4.setId("proposition_button");
        this.grid.add(proposition4, 0, 7, 3, 2);
        this.grid.setMargin(proposition4, new Insets(35, 38, 45, 38));

        this.openInBrowserButton = new Button();
        this.openInBrowserLogo = new Image(new FileInputStream(Paths.OPEN_IN_BROWSER_ICON.getPath()), 39, 39, true, true);
        this.openInBrowserButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.openInBrowserButton.setAlignment(Pos.CENTER);
        this.openInBrowserButton.setGraphic(new ImageView(openInBrowserLogo));
        this.openInBrowserButton.setId("question_bottom_open_in_browser_button");
        this.openInBrowserButton.setDisable(true);
        this.grid.add(openInBrowserButton, 0, 8, 1, 2);
        this.grid.setMargin(openInBrowserButton, new Insets(40, 30, 45, 38));

        this.infoButton = new Button();
        this.addLogo = new Image(new FileInputStream(Paths.ADD_ICON.getPath()), 39, 39, true, true);
        this.infoButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.infoButton.setAlignment(Pos.CENTER);
        this.infoButton.setGraphic(new ImageView(addLogo));
        this.infoButton.setDisable(true);
        this.grid.add(infoButton, 1, 8, 1, 2);
        this.grid.setMargin(infoButton, new Insets(40, 20, 45, 20));

        this.nextQuestionButton = new Button();
        this.skipNextLogo = new Image(new FileInputStream(Paths.SKIP_NEXT_ICON.getPath()), 39, 39, true, true);
        this.nextQuestionButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.nextQuestionButton.setAlignment(Pos.CENTER);
        this.nextQuestionButton.setGraphic(new ImageView(skipNextLogo));
        this.nextQuestionButton.setId("question_bottom_next_button");
        this.nextQuestionButton.setDisable(true);
        this.grid.add(nextQuestionButton, 2, 8, 1, 2);
        this.grid.setMargin(nextQuestionButton, new Insets(40, 38, 45, 5)); 

        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9, 3, 1);
        this.grid.setMargin(authorLabel, new Insets(30, 0, 0, 0));

        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public void colorPropositions() {
        this.proposition1.setId("proposition_button");
        this.proposition2.setId("proposition_button");
        this.proposition3.setId("proposition_button");
        this.proposition4.setId("proposition_button");
    }

    public void colorCorrectAnswer(String answer) {
        if(proposition1.getText().equals(answer)) {
            this.proposition1.setId("correct_answer");
        }
        else if(proposition2.getText().equals(answer)) {
            this.proposition2.setId("correct_answer");
        }
        else if(proposition3.getText().equals(answer)) {
            this.proposition3.setId("correct_answer");
        }
        else if(proposition4.getText().equals(answer)) {
            this.proposition4.setId("correct_answer");
        }
    }

    public void colorWrongAnswer(String answer) {
        if(proposition1.getText().equals(answer)) {
            this.proposition1.setId("wrong_answer");
        }
        else if(proposition2.getText().equals(answer)) {
            this.proposition2.setId("wrong_answer");
        }
        else if(proposition3.getText().equals(answer)) {
            this.proposition3.setId("wrong_answer");
        }
        else if(proposition4.getText().equals(answer)) {
            this.proposition4.setId("wrong_answer");
        }
    }

    public GridPane getGrid() {
        return grid;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public Label getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(Label questionLabel) {
        this.questionLabel = questionLabel;
    }

    public Image getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(Image coverImage) {
        this.coverImage = coverImage;
    }

    public Label getCoverLabel() {
        return coverLabel;
    }

    public void setCoverLabel(Label coverLabel) {
        this.coverLabel = coverLabel;
    }

    public Button getProposition1() {
        return proposition1;
    }

    public void setProposition1(Button proposition1) {
        this.proposition1 = proposition1;
    }

    public Button getProposition2() {
        return proposition2;
    }

    public void setProposition2(Button proposition2) {
        this.proposition2 = proposition2;
    }

    public Button getProposition3() {
        return proposition3;
    }

    public void setProposition3(Button proposition3) {
        this.proposition3 = proposition3;
    }

    public Button getProposition4() {
        return proposition4;
    }

    public void setProposition4(Button proposition4) {
        this.proposition4 = proposition4;
    }

    public Button getOpenInBrowserButton() {
        return openInBrowserButton;
    }

    public void setOpenInBrowserButton(Button openInBrowserButton) {
        this.openInBrowserButton = openInBrowserButton;
    }

    public Button getInfoButton() {
        return infoButton;
    }

    public void setInfoButton(Button infoButton) {
        this.infoButton = infoButton;
    }

    public Button getNextQuestionButton() {
        return nextQuestionButton;
    }

    public void setNextQuestionButton(Button nextQuestionButton) {
        this.nextQuestionButton = nextQuestionButton;
    }
}