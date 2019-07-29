/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-29 16:51:56 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-29 18:11:50
 */

package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Paths;

public class DiscoverScene extends SceneApp {

    private GridPane grid;
    private Image appLogo;
    private Label appLogoLabel;
    private Label titleLabel;
    private Image coverImage;
    private Label coverLabel;
    private Label infoLabel;
    private Button openInBrowserButton;
    private Image openInBrowserLogo;
    private Button closeButton;
    private Image closeLogo;
    private Button nextQuestionButton;
    private Image skipNextLogo;
    private Label authorLabel;

    public DiscoverScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(3, 10);
        //this.grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 18, 18, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 1, 0, 1, 1);
        this.grid.setMargin(appLogoLabel, new Insets(10, 10, 50, 10));

        this.titleLabel = new Label("Question");
        this.titleLabel.setWrapText(true);
        this.titleLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.titleLabel.setAlignment(Pos.CENTER);
        this.titleLabel.setTextAlignment(TextAlignment.CENTER);
        this.titleLabel.setId("question_label");
        this.grid.add(titleLabel, 0, 0, 3, 2);
        this.grid.setMargin(titleLabel, new Insets(20, 10, 0, 10));

        this.coverImage = new Image(new FileInputStream("/home/alexandre/Desktop/code_perso/[JAVA] The Music Quiz/DB/hiphop/FR_hiphop/covers/SCH - A7.jpeg"), 150, 150, true, true);
        this.coverLabel = new Label();
        this.coverLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.coverLabel.setGraphic(new ImageView(coverImage));
        this.coverLabel.setAlignment(Pos.CENTER);
        this.grid.add(coverLabel, 0, 3, 3, 1);
        this.grid.setMargin(coverLabel, new Insets(10, 0, 45, 0));

        this.infoLabel = new Label();
        this.infoLabel.setWrapText(true);
        this.infoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.infoLabel.setAlignment(Pos.CENTER);
        this.infoLabel.setTextAlignment(TextAlignment.CENTER);
        this.infoLabel.setId("info_label");
        this.grid.add(infoLabel, 0, 4, 3, 5);
        this.grid.setMargin(infoLabel, new Insets(35, 18, 40, 18));

        this.openInBrowserButton = new Button();
        this.openInBrowserLogo = new Image(new FileInputStream(Paths.OPEN_IN_BROWSER_ICON.getPath()), 39, 39, true, true);
        this.openInBrowserButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.openInBrowserButton.setAlignment(Pos.CENTER);
        this.openInBrowserButton.setGraphic(new ImageView(openInBrowserLogo));
        this.openInBrowserButton.setId("question_bottom_open_in_browser_button");
        this.grid.add(openInBrowserButton, 0, 8, 1, 2);
        this.grid.setMargin(openInBrowserButton, new Insets(40, 30, 45, 38));

        this.closeButton = new Button();
        this.closeLogo = new Image(new FileInputStream(Paths.CLOSE_ICON.getPath()), 39, 39, true, true);
        this.closeButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.closeButton.setAlignment(Pos.CENTER);
        this.closeButton.setGraphic(new ImageView(closeLogo));
        this.grid.add(closeButton, 1, 8, 1, 2);
        this.grid.setMargin(closeButton, new Insets(40, 20, 45, 20));

        this.nextQuestionButton = new Button();
        this.skipNextLogo = new Image(new FileInputStream(Paths.SKIP_NEXT_ICON.getPath()), 39, 39, true, true);
        this.nextQuestionButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.nextQuestionButton.setAlignment(Pos.CENTER);
        this.nextQuestionButton.setGraphic(new ImageView(skipNextLogo));
        this.nextQuestionButton.setId("question_bottom_next_button");
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

    public GridPane getGrid() {
        return grid;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public Label getCoverLabel() {
        return coverLabel;
    }

    public Button getOpenInBrowserButton() {
        return openInBrowserButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getNextQuestionButton() {
        return nextQuestionButton;
    }
}