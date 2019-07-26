/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 14:42:43 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 16:23:05
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

public class GenreSelectionScene extends SceneApp {

    private GridPane grid;
    private Label mainTitle;
    private Image appLogo;
    private Label appLogoLabel;
    private Button hiphopButton;
    private Button rockButton;
    private Button electroButton;
    private Button popButton;

    private Label authorLabel;

    public GenreSelectionScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(1, 10);
        //grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.mainTitle = new Label("Select a genre");
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

        this.hiphopButton = new Button("Hip-hop");
        this.hiphopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.hiphopButton.setAlignment(Pos.CENTER);
        this.grid.add(hiphopButton, 0, 3, 1, 2);
        this.grid.setMargin(hiphopButton, new Insets(50, 50, 50, 50));

        this.rockButton = new Button("Rock");
        this.rockButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.rockButton.setAlignment(Pos.CENTER);
        this.rockButton.setId("not_available_button");
        this.grid.add(rockButton, 0, 4, 1, 2);
        this.grid.setMargin(rockButton, new Insets(100, 50, 50, 50));

        this.electroButton = new Button("Electro");
        this.electroButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.electroButton.setAlignment(Pos.CENTER);
        this.electroButton.setId("not_available_button");
        this.grid.add(electroButton, 0, 5, 1, 2);
        this.grid.setMargin(electroButton, new Insets(150, 50, 50, 50));

        this.popButton = new Button("Pop");
        this.popButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.popButton.setAlignment(Pos.CENTER);
        this.popButton.setId("not_available_button");
        this.grid.add(popButton, 0, 6, 1, 2);
        this.grid.setMargin(popButton, new Insets(200, 50, 50, 50));

        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9);

        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public Button getHiphopButton() {
        return hiphopButton;
    }

    public Button getRockButton() {
        return rockButton;
    }

    public Button getElectroButton() {
        return electroButton;
    }

    public Button getPopButton() {
        return popButton;
    }

    public GridPane getGrid() {
        return grid;
    }
}