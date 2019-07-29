/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-28 20:10:57 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-29 11:36:37
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

public class ResultsScene extends SceneApp {
    private GridPane grid;
    private Image appLogo;
    private Label appLogoLabel;
    private Label titleLabel;
    private Label genreLabel;
    private Label timeLabel;
    private Label scoreLabel;
    private Label numberQuestionLabel;
    private Button homeButton;
    private Button replayButton;
    private Image replayLogo;
    private Image homeLogo;
    private Label authorLabel;

    public ResultsScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(3, 10);
        //this.grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.titleLabel = new Label("Results");
        this.titleLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.titleLabel.setAlignment(Pos.CENTER);
        this.titleLabel.setTextAlignment(TextAlignment.CENTER);
        this.titleLabel.setId("main_title");
        this.grid.add(titleLabel, 0, 0, 3, 2);
        this.grid.setMargin(titleLabel, new Insets(20, 10, 0, 10));

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 72, 72, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 0, 1, 3, 2);
        this.grid.setMargin(appLogoLabel, new Insets(30, 0, 0, 0));

        this.genreLabel = new Label("Genre label");
        this.genreLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.genreLabel.setAlignment(Pos.CENTER);
        this.genreLabel.setTextAlignment(TextAlignment.CENTER);
        this.genreLabel.setId("question_label");
        this.grid.add(genreLabel, 0, 3, 3, 1);
        this.grid.setMargin(genreLabel, new Insets(20, 10, 0, 10));

        this.scoreLabel = new Label("Score");
        this.scoreLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.scoreLabel.setAlignment(Pos.CENTER);
        this.scoreLabel.setTextAlignment(TextAlignment.CENTER);
        this.scoreLabel.setId("score_1");
        this.grid.add(scoreLabel, 0, 4, 1, 2);
        this.grid.setMargin(scoreLabel, new Insets(40, 10, 30, 10));

        this.numberQuestionLabel = new Label("Correct");
        this.numberQuestionLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.numberQuestionLabel.setAlignment(Pos.CENTER);
        this.numberQuestionLabel.setTextAlignment(TextAlignment.CENTER);
        this.numberQuestionLabel.setId("score_2");
        this.grid.add(numberQuestionLabel, 1, 4, 1, 2);
        this.grid.setMargin(numberQuestionLabel, new Insets(40, 10, 30, 10));

        this.timeLabel = new Label("Time");
        this.timeLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.timeLabel.setAlignment(Pos.CENTER);
        this.timeLabel.setTextAlignment(TextAlignment.CENTER);
        this.timeLabel.setId("score_3");
        this.grid.add(timeLabel, 2, 4, 1, 2);
        this.grid.setMargin(timeLabel, new Insets(40, 10, 30, 10));

        this.homeButton = new Button();
        this.homeLogo = new Image(new FileInputStream(Paths.HOME_ICON.getPath()), 39, 39, true, true);
        this.homeButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.homeButton.setAlignment(Pos.CENTER);
        this.homeButton.setGraphic(new ImageView(homeLogo));
        this.homeButton.setId("settings_button");
        this.grid.add(homeButton, 0, 7, 2, 1);
        this.grid.setMargin(homeButton, new Insets(0, 100, 5, 20));

        this.replayButton = new Button();
        this.replayLogo = new Image(new FileInputStream(Paths.REPLAY_ICON.getPath()), 39, 39, true, true);
        this.replayButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.replayButton.setAlignment(Pos.CENTER);
        this.replayButton.setGraphic(new ImageView(replayLogo));
        this.replayButton.setId("start_button");
        this.grid.add(replayButton, 1, 7, 2, 1);
        this.grid.setMargin(replayButton, new Insets(0, 20, 5, 100));

        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9, 3, 1);
        this.grid.setMargin(authorLabel, new Insets(30, 0, 0, 0));

        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public GridPane getGrid() {
        return grid;
    }

    public Label getGenreLabel() {
        return genreLabel;
    }

    public void setGenreLabel(Label genreLabel) {
        this.genreLabel = genreLabel;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public Label getNumberQuestionLabel() {
        return numberQuestionLabel;
    }

    public void setNumberQuestionLabel(Label numberQuestionLabel) {
        this.numberQuestionLabel = numberQuestionLabel;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(Button homeButton) {
        this.homeButton = homeButton;
    }

    public Button getReplayButton() {
        return replayButton;
    }

    public void setReplayButton(Button replayButton) {
        this.replayButton = replayButton;
    }
}