/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 11:24:28 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 18:05:08
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

public class ModeSelectionScene extends SceneApp {

    private GridPane grid;
    private Label mainTitle;
    private Image appLogo;
    private Label appLogoLabel;
    private Button whoButton;
    private Image whoLogo;
    private Button whenButton;
    private Image whenLogo;
    private Button byCoverButton;
    private Image byCoverLogo;
    private Button whichOneButton;
    private Image whichOneLogo;
    private Button randomButton;
    private Image randomLogo;
    private Button discoverButton;
    private Image discoverLogo;
    private Label authorLabel;

    public ModeSelectionScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(2, 10);
        //grid.setGridLinesVisible(true);
        super.setRoot(grid);

        this.mainTitle = new Label("Select a mode");
        this.mainTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.mainTitle.setAlignment(Pos.CENTER);
        this.mainTitle.setId("main_title");
        this.grid.add(mainTitle, 0, 0, 2, 2);

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 72, 72, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 0, 1, 2, 2);

        this.whoButton = new Button("Who ?");
        this.whoLogo = new Image(new FileInputStream(Paths.PERSON_ICON.getPath()), 64, 64, true, true);
        this.whoButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.whoButton.setAlignment(Pos.CENTER);
        this.whoButton.setGraphic(new ImageView(whoLogo));
        this.whoButton.setId("mode_button");
        this.grid.add(whoButton, 0, 3, 1, 2);
        this.grid.setMargin(whoButton, new Insets(15, 25, 15, 25));

        this.whenButton = new Button("When ?");
        this.whenLogo = new Image(new FileInputStream(Paths.EVENT_ICON.getPath()), 64, 64, true, true);
        this.whenButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.whenButton.setAlignment(Pos.CENTER);
        this.whenButton.setGraphic(new ImageView(whenLogo));
        this.whenButton.setId("mode_button");
        this.grid.add(whenButton, 1, 3, 1, 2);
        this.grid.setMargin(whenButton, new Insets(15, 25, 15, 25));

        this.byCoverButton = new Button("By cover");
        this.byCoverLogo = new Image(new FileInputStream(Paths.IMAGE_ICON.getPath()), 64, 64, true, true);
        this.byCoverButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.byCoverButton.setAlignment(Pos.CENTER);
        this.byCoverButton.setGraphic(new ImageView(byCoverLogo));
        this.byCoverButton.setId("mode_button");
        this.grid.add(byCoverButton, 0, 5, 1, 2);
        this.grid.setMargin(byCoverButton, new Insets(15, 25, 15, 25));

        this.whichOneButton = new Button("Which one ?");
        this.whichOneLogo = new Image(new FileInputStream(Paths.HELP_ICON.getPath()), 64, 64, true, true);
        this.whichOneButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.whichOneButton.setAlignment(Pos.CENTER);
        this.whichOneButton.setGraphic(new ImageView(whichOneLogo));
        this.whichOneButton.setId("mode_button");
        this.grid.add(whichOneButton, 1, 5, 1, 2);
        this.grid.setMargin(whichOneButton, new Insets(15, 25, 15, 25));

        this.randomButton = new Button("Random");
        this.randomLogo = new Image(new FileInputStream(Paths.SHUFFLE_ICON.getPath()), 64, 64, true, true);
        this.randomButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.randomButton.setAlignment(Pos.CENTER);
        this.randomButton.setGraphic(new ImageView(randomLogo));
        this.randomButton.setId("mode_button");
        this.grid.add(randomButton, 0, 7, 1, 2);
        this.grid.setMargin(randomButton, new Insets(15, 25, 15, 25));

        this.discoverButton = new Button("Discover");
        this.discoverLogo = new Image(new FileInputStream(Paths.SEARCH_ICON.getPath()), 64, 64, true, true);
        this.discoverButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.discoverButton.setAlignment(Pos.CENTER);
        this.discoverButton.setGraphic(new ImageView(discoverLogo));
        this.discoverButton.setId("mode_button");
        this.discoverButton.setDisable(true);
        this.grid.add(discoverButton, 1, 7, 1, 2);
        this.grid.setMargin(discoverButton, new Insets(15, 25, 15, 25));

        this.authorLabel = new Label("Alexandre Ladrière - 2019");
        this.authorLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.authorLabel.setAlignment(Pos.CENTER);
        this.authorLabel.setTextAlignment(TextAlignment.CENTER);
        this.authorLabel.setId("author_label");
        this.grid.add(authorLabel, 0, 9, 2, 1);
        this.grid.setMargin(authorLabel, new Insets(30, 0, 0, 0));
        
        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }

    public Button getWhoButton() {
        return whoButton;
    }

    public Button getWhenButton() {
        return whenButton;
    }

    public Button getByCoverButton() {
        return byCoverButton;
    }

    public Button getWhichOneButton() {
        return whichOneButton;
    }

    public Button getRandomButton() {
        return randomButton;
    }

    public Button getDiscoverButton() {
        return discoverButton;
    }

    public GridPane getGrid() {
        return grid;
    }
}