/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 13:44:34 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 18:05:30
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

public class HomeScene extends SceneApp {

    private GridPane grid;
    private Label mainTitle;
    private Image appLogo;
    private Label appLogoLabel;
    private Button startButton;
    private Button settingsButton;
    private Label authorLabel;

    public HomeScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(1, 10);
        super.setRoot(grid);
        //grid.setGridLinesVisible(true);

        this.mainTitle = new Label("The Music Quiz");
        this.mainTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.mainTitle.setAlignment(Pos.CENTER);
        this.mainTitle.setId("main_title");
        this.grid.add(mainTitle, 0, 1, 1, 1);
        
        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 105, 105, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 0, 3, 1, 1);
        
        this.startButton = new Button("Start");
        this.startButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.startButton.setAlignment(Pos.CENTER);
        this.startButton.setId("start_button");
        this.grid.add(startButton, 0, 5, 1, 1);
        this.grid.setMargin(startButton, new Insets(5, 50, 5, 50));
        
        this.settingsButton = new Button("Settings");
        this.settingsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.settingsButton.setAlignment(Pos.CENTER);
        this.settingsButton.setId("settings_button");
        this.grid.add(settingsButton, 0, 7, 1, 1);
        this.grid.setMargin(settingsButton, new Insets(5, 50, 5, 50));
        
        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9);
        this.grid.setMargin(authorLabel, new Insets(30, 0, 0, 0));
        
        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public GridPane getGrid() {
        return grid;
    }
}