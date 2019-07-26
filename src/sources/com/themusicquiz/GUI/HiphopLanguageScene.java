/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 15:05:54 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 18:05:45
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

public class HiphopLanguageScene extends SceneApp {

    private GridPane grid;
    private Label mainTitle;
    private Image appLogo;
    private Label appLogoLabel;
    private Button FRhiphopButton;
    private Button UShiphopButton;
    private Button DEhiphopButton;
    private Button IThiphopButton;

    private Label authorLabel;

    public HiphopLanguageScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(1, 10);
        //grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.mainTitle = new Label("Select a sub-genre");
        this.mainTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.mainTitle.setAlignment(Pos.CENTER);
        this.mainTitle.setId("main_title");
        this.grid.add(mainTitle, 0, 0, 1, 2);

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 72, 72, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 0, 1, 1, 2);

        this.FRhiphopButton = new Button("French Hip-hop");
        this.FRhiphopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.FRhiphopButton.setAlignment(Pos.CENTER);
        this.grid.add(FRhiphopButton, 0, 3, 1, 2);
        this.grid.setMargin(FRhiphopButton, new Insets(50, 50, 50, 50));

        this.UShiphopButton = new Button("US Hip-hop");
        this.UShiphopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.UShiphopButton.setAlignment(Pos.CENTER);
        this.grid.add(UShiphopButton, 0, 4, 1, 2);
        this.grid.setMargin(UShiphopButton, new Insets(100, 50, 50, 50));

        this.DEhiphopButton = new Button("German Hip-hop");
        this.DEhiphopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.DEhiphopButton.setAlignment(Pos.CENTER);
        this.DEhiphopButton.setDisable(true);
        this.grid.add(DEhiphopButton, 0, 5, 1, 2);
        this.grid.setMargin(DEhiphopButton, new Insets(150, 50, 50, 50));

        this.IThiphopButton = new Button("Italian Hip-hop");
        this.IThiphopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.IThiphopButton.setAlignment(Pos.CENTER);
        this.IThiphopButton.setDisable(true);
        this.grid.add(IThiphopButton, 0, 6, 1, 2);
        this.grid.setMargin(IThiphopButton, new Insets(200, 50, 50, 50));

        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9);
        this.grid.setMargin(authorLabel, new Insets(30, 0, 0, 0));

        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public Button getFRhiphopButton() {
        return FRhiphopButton;
    }

    public Button getUShiphopButton() {
        return UShiphopButton;
    }

    public Button getDEhihopButton() {
        return DEhiphopButton;
    }

    public Button getIThihopButton() {
        return IThiphopButton;
    }

    public GridPane getGrid() {
        return grid;
    }
}